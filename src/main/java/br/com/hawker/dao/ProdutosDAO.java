package br.com.hawker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.hawker.to.ProdutosTO;
import oracle.jdbc.pool.OracleDataSource;

public class ProdutosDAO {

	private String connString = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
	private Connection conn;	
	private static List<ProdutosTO> produtos;
	
	public ProdutosDAO() throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL(connString);
		ods.setUser("rm86866");
		ods.setPassword("290396");
		
		conn = ods.getConnection();
	}
	
	//Seleção de Produtos
	public List<ProdutosTO> select() throws SQLException{
		produtos = new ArrayList<ProdutosTO>();
		
		String sql = "SELECT * FROM T_GI_PRODUTOS";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			int id = rs.getInt("CD_PRODUTO");
			String nome = rs.getString("NM_PRODUTO");
			String venda = rs.getString("DS_METRICA_VENDA");
			
			ProdutosTO p = new ProdutosTO();
			p.setId(id);
			p.setNome(nome);
			p.setVenda(venda);
			
			produtos.add(p);
			
		}
		
		return produtos;
	}

}
