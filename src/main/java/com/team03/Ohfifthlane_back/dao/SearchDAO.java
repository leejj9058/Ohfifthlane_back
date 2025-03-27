package com.team03.Ohfifthlane_back.dao;

import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.team03.Ohfifthlane_back.vo.ChargingStationVO;
import com.team03.Ohfifthlane_back.vo.PublicParkingVO;

@Component
public class SearchDAO {

	@Autowired
	SqlSession session;
	
	@Value("${naver.client-id}")
	private String NAVER_API_ID;

	@Value("${naver.secret}")
	private String NAVER_API_SECRET;
	
	public List<Map<String, String>> searchDestination(String query) {
		List<Map<String, String>> parkings = new ArrayList<>();

		try {
			// UTF-8로 인코딩된 검색어 생성
			ByteBuffer buffer = StandardCharsets.UTF_8.encode(query);
			String encode = StandardCharsets.UTF_8.decode(buffer).toString();

			// 네이버 검색 API를 호출하기 위한 URI 생성
			URI uri = UriComponentsBuilder.fromUriString("https://openapi.naver.com").path("/v1/search/local")
					.queryParam("query", encode).queryParam("display", 10).queryParam("start", 1)
					.queryParam("sort", "random").encode().build().toUri();

			// RestTemplate을 사용하여 네이버 API에 요청을 보냄
			RestTemplate restTemplate = new RestTemplate();
			RequestEntity<Void> req = RequestEntity.get(uri).header("X-Naver-Client-Id", NAVER_API_ID)
					.header("X-Naver-Client-Secret", NAVER_API_SECRET).build();

			// API 응답 데이터를 JSON 형식으로 변환
			ResponseEntity<String> response = restTemplate.exchange(req, String.class);
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode rootNode = objectMapper.readTree(response.getBody());

			// API 응답 확인용 디버깅 출력
	        System.out.println("Response: " + response.getBody());
	        
			// 검색 결과 중에서 장소 정보를 추출하여 리스트에 저장
			JsonNode itemsNode = rootNode.path("items");
			for (JsonNode itemNode : itemsNode) {
				Map<String, String> parking = new HashMap<>();
				parking.put("title", itemNode.path("title").asText()); // 장소 이름
				parking.put("address", itemNode.path("address").asText()); // 장소 주소
				/*
				 * restaurant.put("mapx", itemNode.path("mapx").asText());
				 * restaurant.put("mapy", itemNode.path("mapy").asText());
				 */
				// 위도와 경도를 double 형식으로 변환하여 저장
				double latitude = Double.parseDouble(itemNode.path("mapy").asText()) / 1e7; // 위도
				double longitude = Double.parseDouble(itemNode.path("mapx").asText()) / 1e7; // 경도
				parking.put("latitude", String.valueOf(latitude));
				parking.put("longitude", String.valueOf(longitude));

				parkings.add(parking); // 리스트에 추가
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return parkings;
	}

	public List<ChargingStationVO> getChargingStationList() {
		
		return session.selectList("getChargingStationList");
	}

	public List<PublicParkingVO> getPublicParkingList() {
		return session.selectList("getPublicParkingList");
	}
	
	
	
}
