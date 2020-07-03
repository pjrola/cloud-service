package com.cloud.service.service;

import com.cloud.service.domain.Instance;
import com.cloud.service.domain.InstanceState;
import com.cloud.service.domain.Provider;
import com.cloud.service.exception.ResourceNotFoundException;
import com.cloud.service.repository.InstanceRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class InstanceDataBaseServiceTest {

    @InjectMocks
    private InstanceDatabaseService service;

    @Mock
    private InstanceRepository repository;

    private Instance instance;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        instance = new Instance();
        instance.setName("Hello World");
        instance.setRemoteId("cdaf2971-f409");
        instance.setLocked(false);
        instance.setProvider(Provider.AWS);
        instance.setRegion("us-east-1");
        instance.setState(InstanceState.PENDING);
        instance.setUrl("127.0.0.1");
    }

    @Test
    public void canRetrieveInstanceById() throws Exception {
        when(repository.findById(1L)).thenReturn(Optional.ofNullable(instance));
        Optional<Instance> result = Optional.ofNullable(service.get(1L));
        assertThat(result.isPresent()).isTrue();
        assertThat(result.get()).isEqualTo(instance);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void throwsResourceNotFoundExceptionWhenRetrieveInstanceByIdNotFound() throws Exception {
        when(service.get(1L))
            .thenThrow(new ResourceNotFoundException(String.valueOf(1L)));
    }

    @Test
    public void canRetrieveInstanceByRemoteId() throws Exception {
        when(repository.findByRemoteId(instance.getRemoteId())).thenReturn(Optional.ofNullable(instance));
        Optional<Instance> result = Optional.ofNullable(service.get(instance.getRemoteId()));
        assertThat(result.isPresent()).isTrue();
        assertThat(result.get()).isEqualTo(instance);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void throwsResourceNotFoundExceptionWhenRetrieveInstanceByRemoteIdNotFound() throws Exception {
        when(service.get(instance.getRemoteId()))
            .thenThrow(new ResourceNotFoundException(instance.getRemoteId()));
    }

    @Test
    public void canDeleteById() throws Exception {
        when(repository.findById(1L)).thenReturn(Optional.ofNullable(instance));
        Optional<Instance> result = Optional.ofNullable(service.get(1L));
        service.delete(1L);
        verify(repository, times(1)).delete(result.get());
    }

    @Test
    public void canRetrievePageList() {
        List<Instance> instanceList = new ArrayList<>();
        instanceList.add(instance);
        instanceList.add(instance);
        instanceList.add(instance);

        Page<Instance> pagedResponse = new PageImpl<>(instanceList);

        when(repository.findAll(PageRequest.of(0, 10))).thenReturn(pagedResponse);

        Page<Instance> result = service.findAll(PageRequest.of(0, 10));
        assertThat(result.hasContent()).isTrue();
        assertThat(result.getTotalElements()).isEqualTo(3);
    }

    @Test
    public void canCreateInstance() {
        when(repository.save(instance)).thenReturn(instance);
        Instance result = service.create(instance);
        assertThat(instance).isEqualTo(result);
        verify(repository, times(1)).save(instance);
    }

    @Test
    public void createdInstanceHasCreatedAtDate() {
        when(repository.save(any(Instance.class))).then(returnsFirstArg());
        Instance result = service.create(instance);
        assertThat(result.getCreatedAt()).isNotNull();
    }

    @Test
    public void updatedInstanceHasUpdatedAtDate() {
        when(repository.save(any(Instance.class))).then(returnsFirstArg());
        Instance result = service.create(instance);
        assertThat(result.getUpdatedAt()).isNotNull();
    }

    @Test
    public void canUpdateInstance() throws Exception {
        String updatedName = "dlroW olleH";
        when(repository.findById(1L)).thenReturn(Optional.ofNullable(instance));
        Optional<Instance> result = Optional.ofNullable(service.get(1L));
        result.get().setName(updatedName);
        service.update(1L, result.get());
        verify(repository, times(1)).save(instance);
        assertThat(result.get().getName()).isEqualTo(updatedName);
    }

}
