package com.wzn.bootwebframe;

import com.wzn.bootwebframe.service.UisRefundService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class BootwebframeApplicationTests {

	@Autowired
	UisRefundService uisRefundService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testUisGoodsRefund(){
		String record = "898310107420110,消费,62251111222233331,20171201,1.32,10188W10188W,1.32,0,,,,104200,1,1,,,,,";
		uisRefundService.doGoodsReturnSsl(record);
		log.info("done!!!!");
	}


}
