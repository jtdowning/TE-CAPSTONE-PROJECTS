package com.techelevator.campground.model.jdbc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import com.techelevator.campground.model.Site;
import com.techelevator.campground.model.SiteDAO;

public class JDBCSiteDAO implements SiteDAO {

private JdbcTemplate jdbcTemplate;
	
	public JDBCSiteDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Site> getAvailableSites(long campgroundId, LocalDate fromDate, LocalDate toDate) {
		List<Site> availSites = new ArrayList<>();
		
		String sqlAvailSites = "SELECT * " +
								"FROM site " +
								"WHERE campground_id = ? AND site_id NOT IN (" +
									"SELECT site_id " +
									"FROM reservation " +
									"WHERE (? BETWEEN from_date AND to_date) " +
									"AND (? BETWEEN from_date AND to_date)" +
									")";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlAvailSites, campgroundId, fromDate, toDate);
		
		while(results.next()) {
			Site theSite = new Site();
			
			theSite.setSiteId(results.getLong("site_id"));
			theSite.setCampgroundId(results.getLong("campground_id"));
			theSite.setSiteNumber(results.getLong("site_number"));
			theSite.setMaxOccupancy(results.getLong("max_occupancy"));
			theSite.setAccessible(results.getBoolean("accessible"));
			theSite.setMaxLengthRV(results.getLong("max_rv_length"));
			theSite.setUtilities(results.getBoolean("utilities"));
			
			availSites.add(theSite);
		}
		return availSites;
	}

}
