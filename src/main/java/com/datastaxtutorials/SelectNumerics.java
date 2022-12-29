package com.datastaxtutorials;

import java.net.InetSocketAddress;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;
import com.datastax.oss.driver.api.core.cql.SimpleStatement;
import com.datastax.oss.driver.api.querybuilder.QueryBuilder;
import com.datastax.oss.driver.api.querybuilder.select.Select;
import com.datastax.oss.driver.api.querybuilder.term.Term;
import com.datastax.oss.driver.internal.querybuilder.term.TypeHintTerm;
import com.datastax.oss.protocol.internal.ProtocolConstants.DataType;

public class SelectNumerics {
	
	public static void main(String[] args) {
		String strUser = System.getenv("CASSANDRA_USER");
		String strPass = System.getenv("CASSANDRA_PASS");
		
		try (CqlSession session = CqlSession.builder()
				.addContactPoint(new InetSocketAddress("127.0.0.1",9042))
				.withLocalDatacenter("datacenter1")
				.withAuthCredentials(strUser, strPass)
				.build()) {

			  Select query = QueryBuilder.selectFrom("stackoverflow", "numerics")
					  .column("num")
					  .column("dec")
					  .column("doub")
					  .column("flt")
					  .whereColumn("num")
					  	  .isEqualTo(QueryBuilder.literal(1));
			  SimpleStatement statement = query.build();

			  ResultSet rs = session.execute(statement);
			  Row row = rs.one();
			  
			  System.out.println("num(int) = " + row.getInt("num"));
			  System.out.println("decimal = " + row.getBigDecimal("dec"));
			  System.out.println("double = " + row.getDouble("doub"));
			  System.out.println("float = " + row.getFloat("flt"));
			  
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
	}
}
