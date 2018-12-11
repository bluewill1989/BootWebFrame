package com.wzn.bootwebframe.service.webservice.ws.endpoint;

import com.wzn.api.util.AESUtils;

/**
 * 社保系统的ws接口测试
 */
public class TestZqInterfacesWs {

	public static void main(String[] args) {
		try {


			String user = "{\"user\":\"chinaums_test\"}";
			String headJson = "Q8aJ0Wif9gJ6lSrswbSuHUx/ltQ2Lae2bGti0BtsXN06KR4t7vagGAJSwo2fVWWNdEvkGRa1MoFaxTi55DFcbI7vaCU1NYYWWCzHiH8A1jE=";
			String bodyJson = null;
			ZqInterfaceServiceLocator service = new ZqInterfaceServiceLocator();
			String url = "http://172.16.1.33:7001/zqInterfaceTest/service/mainService?wsdl";
			service.setZqInterfaceServiceImplPortEndpointAddress(url);
			ZqInterServiceImpl client = service.getZqInterfaceServiceImplPort();
			String result = client.zqInterface(user, headJson, bodyJson);
			System.out.println("----签到reslut:" + result);

			AESUtils aesUtils = new AESUtils("1Ruk+YGY2xSFz-7K");
			String headStr = "{\"pwd\":\"jJMmVENY\",\"ywtype\":\"YIL_15\",\"zqh\":\"00000000000000000000\",\"user\":\"chinaums_test\"}";
			String bodyStr = "{\"zq_inter_in_list\":[{\"AAE135\":\"441202197912282337\",\"AAC003\":\"吴永健\",\"AKB020\":\"100001\",\"BKC192\":\"20181107\"}]}";
			String result2 = client.zqInterface(user, aesUtils.encryptData(headStr), aesUtils.encryptData(bodyStr));
			System.out.println("----挂号资格判断result:" + result2);
			//decry:{"prm_outerrcode":"-1","prm_outerrmsg":"挂号就诊日期不能早于当前日期","prm_out_zqh":"00000000000000000000","prm_out_inter_id":"20181211112142418851","zq_inter_out_list":null}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
