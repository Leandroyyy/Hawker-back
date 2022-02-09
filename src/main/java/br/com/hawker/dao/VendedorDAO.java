package br.com.hawker.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.hawker.to.VendedorTO;
import oracle.jdbc.pool.OracleDataSource;

public class VendedorDAO {
	
	private String connString = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
	private Connection conn;	
	private static List<VendedorTO> vendedor;

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException exception) {/*ignored*/}
	}

	public VendedorDAO() throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL(connString);
		ods.setUser("rm86866");
		ods.setPassword("290396");
		
		conn = ods.getConnection();
	}
	
	
	//Listar todos os Vendedores para realição de Login
	public List<VendedorTO> select() throws SQLException{
		
		vendedor = new ArrayList<VendedorTO>();
		
		String sql = "SELECT * FROM T_GI_VENDEDOR";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			int id = rs.getInt("CD_VENDEDOR");
			String nome = rs.getString("NM_NOME");
			String dtNascimento = rs.getString("DT_NASCIMENTO");
			String cpf = rs.getString("NR_CPF");
			String cep = rs.getString("CD_CEP");
			String email = rs.getString("DS_EMAIL");
			long telefone = rs.getLong("NR_TELEFONE");
			String senha = rs.getString("DS_SENHA");
			
			vendedor.add(new VendedorTO(id,nome,dtNascimento,cpf,cep,email,telefone,senha));
		}
			
		return vendedor;
	}
	
	//Especificar somente um vendedor para mostrar o Perfil do mesmo
	public VendedorTO select(int id) {
		for(int i = 0; i < vendedor.size(); i++) {
			if(vendedor.get(i).getId() == id) {
				return vendedor.get(i);
			}
		}
		return null;
	}
	
	//Realizar Cadastro do Vendedor
	public void insert(VendedorTO vto) throws SQLException {
		
		String sql = "INSERT INTO T_GI_VENDEDOR (CD_VENDEDOR, NM_NOME, DT_NASCIMENTO, NR_CPF, CD_CEP,"
				+ "DS_EMAIL, NR_TELEFONE, DS_SENHA) VALUES "
				+ "(SQ_GI_VENDEDOR.NEXTVAL, ?, to_date(?,'dd/mm/yyyy'), ?, ?, ?, ?, ?)";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1,vto.getNome());
		ps.setString(2, vto.getDataNascimento());
		ps.setString(3, vto.getCpf());
		ps.setString(4, vto.getCep());
		ps.setString(5, vto.getEmail());
		ps.setLong(6, vto.getTelefone());
		ps.setString(7, vto.getSenha());
		
		ps.execute();
		
	}
	
	//Atualizar dados cadastrais do vendedor
	public void update(VendedorTO vto) throws SQLException {
		String sql = "UPDATE T_GI_VENDEDOR SET NM_NOME=?, DT_NASCIMENTO=to_date(?,'dd/mm/yyyy'), "
				+ "NR_CPF=?, CD_CEP=?,"
				+ "DS_EMAIL=?, NR_TELEFONE=?, DS_SENHA=? WHERE CD_VENDEDOR=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, vto.getNome());
		ps.setString(2, vto.getDataNascimento());
		ps.setString(3, vto.getCpf());
		ps.setString(4, vto.getCep());
		ps.setString(5, vto.getEmail());
		ps.setLong(6, vto.getTelefone());
		ps.setString(7, vto.getSenha());
		
		ps.setInt(8, vto.getId());
		
		ps.executeQuery();
	}
}

