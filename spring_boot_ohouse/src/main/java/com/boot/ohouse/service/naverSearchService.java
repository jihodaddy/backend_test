package com.boot.ohouse.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.boot.ohouse.model.NaverApiVO;

@Service
public class naverSearchService {

	  //public ArrayList<NaverApiVO> naverSearch(String drugName) {
		  public String naverSearch(String drugName) {
	        String clientId = "FrCWpqLpHPw_NLTaqjP_"; //애플리케이션 클라이언트 아이디값"
	        String clientSecret = "pcIWhJfUfJ"; //애플리케이션 클라이언트 시크릿값"
	    	//ArrayList<NaverApiVO> searchList = new ArrayList<NaverApiVO>();

	        String text = null;
	        try {
	            text = URLEncoder.encode(drugName, "UTF-8");
	        } catch (UnsupportedEncodingException e) {
	            throw new RuntimeException("검색어 인코딩 실패",e);
	        }


	        String apiURL = "https://openapi.naver.com/v1/search/encyc?query=" + text;    // json 결과
	        //String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // xml 결과


	        Map<String, String> requestHeaders = new HashMap<>();
	        requestHeaders.put("X-Naver-Client-Id", clientId);
	        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
	        String responseBody = get(apiURL,requestHeaders);


	        System.out.println(responseBody);
	       // searchList = jsonToVoList(responseBody);
	        //System.out.println(searchList.toString());
	        
	        return responseBody;
	    }


	    private static String get(String apiUrl, Map<String, String> requestHeaders){
	        HttpURLConnection con = connect(apiUrl);
	        try {
	            con.setRequestMethod("GET");
	            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
	                con.setRequestProperty(header.getKey(), header.getValue());
	            }


	            int responseCode = con.getResponseCode();
	            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
	                return readBody(con.getInputStream());
	            } else { // 에러 발생
	                return readBody(con.getErrorStream());
	            }
	        } catch (IOException e) {
	            throw new RuntimeException("API 요청과 응답 실패", e);
	        } finally {
	            con.disconnect();
	        }
	    }


	    private static HttpURLConnection connect(String apiUrl){
	        try {
	            URL url = new URL(apiUrl);
	            return (HttpURLConnection)url.openConnection();
	        } catch (MalformedURLException e) {
	            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
	        } catch (IOException e) {
	            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
	        }
	    }


	    private static String readBody(InputStream body){
	        InputStreamReader streamReader = new InputStreamReader(body);


	        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
	            StringBuilder responseBody = new StringBuilder();


	            String line;
	            while ((line = lineReader.readLine()) != null) {
	                responseBody.append(line);
	            }


	            return responseBody.toString();
	        } catch (IOException e) {
	            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
	        }
	    }
	
	    public static ArrayList<NaverApiVO> jsonToVoList(String jsonResultStr){
	    	ArrayList<NaverApiVO> searchList = new ArrayList<NaverApiVO>();
	    	String title, link, description, thumbnail;
	    	
	    	try {
				
				JSONObject jsonObj = new JSONObject(jsonResultStr);
				JSONArray itemsArray = (JSONArray) jsonObj.get("items");
				
				// VO항목 추출
				for(int i=0; i<itemsArray.length();i++) {
					JSONObject tempObj = (JSONObject) itemsArray.get(i);
					title = (String)tempObj.get("title");
					link = (String)tempObj.get("link");
					description = (String)tempObj.get("description");
					thumbnail = (String)tempObj.get("thumbnail");
					
					//VO에 저장
					NaverApiVO vo = new NaverApiVO();
					vo.setTitle(title);
					vo.setLink(link);
					vo.setDescription(description);
					vo.setThumbnail(thumbnail);
					
					//리스트에 추가
					searchList.add(vo);
				}
					
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	
	    	return searchList;
	    }
	    
}
