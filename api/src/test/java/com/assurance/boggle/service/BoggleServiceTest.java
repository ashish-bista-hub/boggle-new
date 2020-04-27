package com.assurance.boggle.service;

import com.assurance.boggle.entity.BoggleDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
class BoggleServiceTest {

    private BoggleService boggleService;

    @Test
    public void testGetBoggleDto() {
        final BoggleDto boggleDto = boggleService.getBoggle();
        assertNotNull(boggleDto);
        assertThat(boggleDto.getMatrix().length, is(4));
        assertFalse(CollectionUtils.isEmpty(boggleDto.getSolutions()));
    }
}