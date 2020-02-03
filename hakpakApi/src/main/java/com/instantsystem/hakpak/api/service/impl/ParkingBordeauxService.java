package com.instantsystem.hakpak.api.service.impl;

import java.time.Duration;
import java.time.LocalTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.instantsystem.hakpak.api.mapper.ParkingBordeauxMapper;
import com.instantsystem.hakpak.api.parking.bordeaux.ParkingBordeauxData;
import com.instantsystem.hakpak.api.service.ParkingService;
import com.instantsystem.hakpak.commons.dto.parking.ParkingDataDto;

@Service
public class ParkingBordeauxService implements ParkingService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ParkingBordeauxService.class);

	private static final String CITY = "Bordeaux";
	private static final String CACHE_NAME = "parkings-bordeaux";

	@Value("${api.parking.bordeaux.url}")
	private String apiParkingBordeauxUrl;

	@Value("${api.client.http.connection.timeout}")
	private int connectionTimeout;

	@Value("${api.client.http.read.timeout}")
	private int readTimeout;

	private ParkingBordeauxMapper parkingBordeauxMapper;
	private CacheManager cacheManager;

	public ParkingBordeauxService(ParkingBordeauxMapper parkingBordeauxMapper, CacheManager cacheManager) {
		this.parkingBordeauxMapper = parkingBordeauxMapper;
		this.cacheManager = cacheManager;
	}

	/**
	 * 
	 */
	@Override
	@Cacheable(value = CACHE_NAME)
	public ParkingDataDto getParkingData() {
		final ParkingDataDto parkingDataDto = new ParkingDataDto();

		getParkingBordeauxData().getFeatureMembers().forEach(f -> {
			parkingDataDto.getParkings().add(this.parkingBordeauxMapper.asParkingDto(f.getParking()));
		});

		return parkingDataDto;
	}

	@Scheduled(fixedRateString = "${api.cache.eviction.rate}")
	protected void evictCache() {
		LOGGER.debug("Cache eviction: cache name={}", CACHE_NAME);
		cacheManager.getCache(CACHE_NAME).clear();
	}

	/**
	 * 
	 * @return
	 */
	private ParkingBordeauxData getParkingBordeauxData() {
		LOGGER.debug("call exteranl API to get all parking data of {} (url: {})", CITY, apiParkingBordeauxUrl);

		LocalTime startTime = LocalTime.now();
		ParkingBordeauxRestTemplate restTemplate = new ParkingBordeauxRestTemplate(connectionTimeout, readTimeout);
		LocalTime endTime = LocalTime.now();

		ParkingBordeauxData response = restTemplate.getForObject(apiParkingBordeauxUrl, ParkingBordeauxData.class);
		LOGGER.debug("Reception of response of exteranl API of parking data of {} (url: {}), Duration={}", CITY,
				apiParkingBordeauxUrl, Duration.between(startTime, endTime));

		return response;
	}
}
