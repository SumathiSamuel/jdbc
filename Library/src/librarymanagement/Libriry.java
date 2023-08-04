package librarymanagement;
import java.sql.*;
public class Libriry {
	
	public static void main(String[]args) throws SQLException {
		InsertBooks();
	}
	public static void InsertBooks() throws SQLException {
		String url = "jdbc:mysql://127.0.0.1:3306/LibraryManagement";
		String username="root";
		String password="root";
		String sql="insert into Library_Record values(?,?,?,?,?,?,?,?,?,?)";

		Connection con= DriverManager.getConnection(url, username, password);
		PreparedStatement pst= con.prepareStatement(sql);
		pst.setInt(1,22);
		pst.setString(2,"Zero To One");
		pst.setString(4,"Peter Thile & Blake Masters");
		pst.setString(3,"Paper Book");
		pst.setInt(5,123);
		pst.setString(6, "Chintu");
		pst.setString(7,"2023-07-15 11:15:45");
		pst.setString(8,"2023-07-18 11:15:45");
		pst.setInt(9,1111);
		pst.setString(10,"Deepak");
		pst.executeUpdate();
		
	}
	
	public static void GetBooks()throws SQLException {
		String url = "jdbc:mysql://127.0.0.1:3306/LibraryManagement";
		String userName = "root";
		String passWord = "root";
		String sql="select*from Library_Record";
		
		Connection con=DriverManager.getConnection(url,userName,passWord);
		Statement st=(Statement) con.createStatement();
		ResultSet rs=st.executeQuery(sql);

		while(rs.next()) {
			
		System.out.println("Book_NO : " + rs.getInt(1));
		System.out.println("Book_Name : " + rs.getString(2));
		System.out.println("Author_Name : " + rs.getString(3));
		System.out.println("Format : " + rs.getString(4));
		System.out.println("Student_Id i: " + rs.getInt(5));
		System.out.println("Student_Name : " + rs.getString(6));
		System.out.println("Brrow_Date : " + rs.getString(7));
		System.out.println("Return_date : " + rs.getString(8));
		System.out.println("Admin_Id : " + rs.getInt(9));
		System.out.println("Admin_Name : " + rs.getString(10));
		
		}
		con.close();
		}
	
		public static void updatBooks()throws SQLException{
			String url ="jdbc:mysql://127.0.0.1:3306/LibraryManagement";
			String username="root";
			String password="root";
			String Sql = "Update Library_Record set Student_Name= 'Dilli' where Student_Id=999";
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement pst = con.prepareStatement(Sql);
			
			pst.executeUpdate();
}
		public static void DeleteBooks()throws SQLException{
			String url ="jdbc:mysql://127.0.0.1:3306/LibraryManagement";
			String username="root";
			String password="root";
			int Book_No= 22;
			String Query="delete from LibraryManagement.Library_Record where Book_No="+Book_No;
	
			Connection con= DriverManager.getConnection(url, username, password);
			Statement st= con.createStatement();
			st.executeUpdate(Query);
		
			con.close();
			
		
	}

}
