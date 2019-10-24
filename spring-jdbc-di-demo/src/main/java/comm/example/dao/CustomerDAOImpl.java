package comm.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import comm.example.model.Customer;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
public class CustomerDAOImpl implements CustomerDAO {
	private DataSource dataSource=null;
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

}