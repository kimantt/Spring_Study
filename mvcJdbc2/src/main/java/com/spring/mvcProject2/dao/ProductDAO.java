package com.spring.mvcProject2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.mvcProject2.dto.ProductDTO;

@Component
public class ProductDAO {
	private DataSource dataFactory;	
	
	@Autowired
	public ProductDAO(DataSource dataSource) {
		try {
			this.dataFactory = dataSource;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<ProductDTO> productSelect() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 데이터 저장해서 반환할 ArrayList 객체 생성
		ArrayList<ProductDTO> prdList = new ArrayList<ProductDTO>();
		
		
		try {
			con = dataFactory.getConnection();
			
			String sql = "select * from product";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				// 하나의 행 처리
				String prdNo = rs.getString("prdNo");
				String prdName = rs.getString("prdName");
				int prdPrice = rs.getInt("prdPrice");
				String prdMaker = rs.getString("prdMaker");
				String prdColor = rs.getString("prdColor");
				int ctgNo = rs.getInt("ctgNo");
				
				// ProductDTO에 담아서
				ProductDTO dto = new ProductDTO();				
				dto.setPrdNo(prdNo);
				dto.setPrdName(prdName);
				dto.setPrdPrice(prdPrice);
				dto.setPrdMaker(prdMaker);
				dto.setPrdColor(prdColor);
				dto.setCtgNo(ctgNo);
				
				// ArrayList에 추가
				prdList.add(dto);
			}			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {}
		}
		
		return prdList;
	}
}




