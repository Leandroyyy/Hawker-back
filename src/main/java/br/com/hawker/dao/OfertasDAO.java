package br.com.hawker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.hawker.to.OfertasTO;
import oracle.jdbc.pool.OracleDataSource;

public class OfertasDAO {

	public static List<OfertasTO> ofertas;
	private String connString = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
	private Connection conn;	
	
	public OfertasDAO() throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL(connString);
		ods.setUser("rm86866");
		ods.setPassword("290396");
		
		conn = ods.getConnection();
	}
	
	//Seleção de Ofertas
	public List<OfertasTO> select() throws SQLException{
		ofertas = new ArrayList<OfertasTO>();
		
		String sql = "SELECT * FROM T_GI_OFERTAS";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			int id = rs.getInt("CD_OFERTA");
			int idProduto = rs.getInt("CD_PRODUTO");
			int quantidade = rs.getInt("NR_QUANTIDADE");
			String dtProducao = rs.getString("DT_PRODUCAO");
			String dtVencimento = rs.getString("DT_VENCIMENTO");
			double valorPreco = rs.getDouble("VLR_PRECO_UNITARIO");
			int idVendedor = rs.getInt("CD_VENDEDOR");
			
			ofertas.add(new OfertasTO(id,idProduto,quantidade,dtProducao,dtVencimento,valorPreco,idVendedor));
		}
		
		return ofertas;
	}
}
