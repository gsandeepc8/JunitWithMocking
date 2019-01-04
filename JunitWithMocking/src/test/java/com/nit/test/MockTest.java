package com.nit.test;

import org.easymock.EasyMock;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.nit.service.WeatherForeCaseService;
import com.oracle.weather.IWeatherForeCaster;

import junit.framework.Assert;

public class MockTest {

	private static IWeatherForeCaster foreCaster = null;
	private static  WeatherForeCaseService weatherService = null;

	@BeforeClass
	public static void before() {
        weatherService=new WeatherForeCaseService();
        //creating mock obj for IWeatherForeCaster interface
        foreCaster=EasyMock.createMock(IWeatherForeCaster.class);
        
        System.out.println(foreCaster.getClass().getName());
        //set bahaviour for that mock obj
        
        
        EasyMock.expect(foreCaster.getTemp(500016)).andReturn(35.4);
        EasyMock.expect(foreCaster.getTemp(500017)).andReturn(30.4);
        EasyMock.expect(foreCaster.getTemp(500018)).andReturn(35.3);
        EasyMock.replay(foreCaster);
        
        //inject this mock obj to service class
        weatherService.setForeCaster(foreCaster);
	}
	
	@Test
	public void getTemp(){
		double temp=0;
		temp=weatherService.findTemp(500018);
		Assert.assertEquals(35.3, temp);
		System.out.println("Temparature : "+temp);
	}
	
	
	@AfterClass
	public static void close(){
      //Clean up code
		foreCaster=null;
		weatherService=null;
	}

}
