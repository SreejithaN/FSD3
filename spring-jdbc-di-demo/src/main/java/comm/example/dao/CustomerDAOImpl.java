package comm.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import comm.example.model.Customer;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
public class CustomerDAOImpl implements CustomerDAO {
		/*private DataSource dataSource=null;
	@Override
	public void createCustomer(Customer customer) {
		Connection connection=null;
		 Statement statement=null;
		 PreparedStatement pStatement=null;
		
		try {
			connection=dataSource.getConnection();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(dataSource.toString());
		try {
			pStatement=connection.prepareStatement("insert into customer1(first_name,last_name,email) values(?,?,?)");
			pStatement.setString(1, customer.getFirstName());
			pStatement.setString(2, customer.getLastName());
			pStatement.setString(3, customer.getEmail());
			pStatement.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		Connection connection=null;
		 Statement statement=null;
		 PreparedStatement pStatement=null;
		
		try {
			connection=dataSource.getConnection();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(dataSource.toString());
		List<Customer> list=new ArrayList<Customer>();
		try {
			statement=connection.createStatement();
			ResultSet rs=statement.executeQuery("select * from customer1");
			
			while(rs.next())
			{
				Customer c = new Customer(rs.getString(1), rs.getString(2), rs.getString(3));
				list.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
		return list;
	}

	public CustomerDAOImpl(DataSource dataSource) {
		
		this.dataSource = dataSource;
	}
*/

	private JdbcTemplate jdbcTemplate;

	@Override
	public void createCustomer(Customer customer) {
		jdbcTemplate.update("insert into customer1(first_name,last_name,email) values (?,?,?)",
				customer.getFirstName(),customer.getLastName(),customer.getEmail());
		
	}

	@Override
	public List<Customer> getAllCustomer() {
		return jdbcTemplate.query("select first_name,last_name,email from customer1", new CustomerMAper());
	}

	@Override
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("delete from customer1 where id=5");
	}

	@Override
	public void updateCustomer(Customer customer) {
		jdbcTemplate.update("update customer1 set first_name=?,last_name=?,email=? where id=1",
				customer.getFirstName(),customer.getLastName(),customer.getEmail());
	}
	
}