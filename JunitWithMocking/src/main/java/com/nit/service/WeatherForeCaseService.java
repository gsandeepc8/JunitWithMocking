package com.nit.service;

import com.oracle.weather.IWeatherForeCaster;

public class WeatherForeCaseService {

	private IWeatherForeCaster foreCaster;

	public void setForeCaster(IWeatherForeCaster foreCaster) {
		this.foreCaster = foreCaster;
	}
	
	public double findTemp(int zipcode){
		double temp=0;
		//call web service method
		temp=foreCaster.getTemp(zipcode);
		return temp;
	}
}
