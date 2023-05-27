//Finished this coding at 4:11 AM 19/1/2022. Sadaqallahulazim.
package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Pair;

public class VotingP extends Application  {
	String matricNo;
	
	public void start(Stage primaryStage) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/votesystem", "root", "syaidi");
		System.out.println("Database connected");
		
		//Login Scene
		TextField tfMatricNo = new TextField();
		PasswordField tfPassword = new PasswordField();
		Button btLogin = new Button("Login");
		Image imageUPM = new Image("D:\\logoupm.jpg");
		ImageView imgUPM = new ImageView(imageUPM);
		
		//initialize pane and add to pane
		GridPane paneLogin = new GridPane();
		paneLogin.setHgap(8);
		paneLogin.setVgap(8);
		
		paneLogin.add(new Label("Matric No: "), 0, 1);
		paneLogin.add(tfMatricNo, 1, 1);
		
		paneLogin.add(new Label("Password: "), 0, 2);
		paneLogin.add(tfPassword, 1, 2);
		
		paneLogin.add(imgUPM, 1, 0);
		imgUPM.setFitWidth(100);
		imgUPM.setFitHeight(60);
		
		paneLogin.add(btLogin, 1, 3);
		final Text actionTarget = new Text();
		paneLogin.add(actionTarget,0,3);
		
		//set center
		paneLogin.setAlignment(Pos.CENTER);
		Scene sceneLogin = new Scene(paneLogin,400,250);
		paneLogin.setStyle("-fx-background-color: #C8234A;");
		
		matricNo = "";
		
		
		//Verification Scene
		
		TextField tfName = new TextField();
		TextField tMatricVer = new TextField();
		TextField tfFaculty = new TextField();
		TextField tfCollege = new TextField();

		//initialize pane and add to scene
		GridPane paneVer = new GridPane();
		

		paneVer.setHgap(5);
		paneVer.setVgap(5);
		
		paneVer.add(new Label("Name: "), 0, 0);
		paneVer.add(tfName, 1, 0);
		
		paneVer.add(new Label("Matric: "), 0, 1);
		paneVer.add(tMatricVer, 1, 1);
		
		paneVer.add(new Label("Faculty: "), 0, 2);
		paneVer.add(tfFaculty, 1, 2);
		
		paneVer.add(new Label("College: "), 0, 3);
		paneVer.add(tfCollege, 1, 3);
		


		paneVer.setAlignment(Pos.CENTER);
		Scene sceneVerify = new Scene(paneVer,400,250);
		paneVer.setStyle("-fx-background-color: #C8234A;");
		
		
		//Vote Scene
		
		 RadioButton voteSyaidi = new RadioButton("");
		 RadioButton voteNeyman = new RadioButton("");
		 RadioButton voteRyan = new RadioButton("");
		 Button doneVote = new Button("Vote");
		 
		 
		//initialize pane and add to scene
		 GridPane votePane = new GridPane();
		  votePane.setHgap(10);
		  votePane.setVgap(10);

		
		 //Add voting
		votePane.add(voteSyaidi, 2, 1);
		votePane.add(voteNeyman, 2, 2);
		votePane.add(voteRyan, 2, 3);
			


		 //add mudah logo
		 Image imageMudah = new Image("C:\\Users\\rezal\\OneDrive\\Pictures\\mudah.png");
		 
		 //Baru tambah nama, syaidi, 10.52
		 Image imageSS = new Image("C:\\Users\\rezal\\Downloads\\syaidis.png");

		 
		 //add Name Logo
		 ImageView imgMudah = new ImageView(imageMudah);
		 ImageView imgSS = new ImageView(imageSS);
		 votePane.add(imgSS,0,1);
		 votePane.add(imgMudah,1,1);
		 imgSS.setFitWidth(180);
		 imgSS.setFitHeight(100);
		 imgMudah.setFitWidth(154);
		 imgMudah.setFitHeight(100);
		 
		 //add sarapan logo
		 Image imageSRP = new Image("C:\\Users\\rezal\\OneDrive\\Pictures\\sarapan.png");
		 Image imageAnwarDini = new Image("C:\\Users\\rezal\\Downloads\\dinis.png");
		 ImageView imgSrp = new ImageView(imageSRP);
		 ImageView imgAnwarDini = new ImageView(imageAnwarDini);
		 votePane.add(imgAnwarDini, 0, 2);
		 votePane.add(imgSrp,1,2);
		 imgAnwarDini.setFitWidth(180);
		 imgAnwarDini.setFitHeight(100);
		 imgSrp.setFitWidth(150);
		 imgSrp.setFitHeight(100);
		 
		 
		 //add garisan logo
		 Image imageGR = new Image("C:\\Users\\rezal\\OneDrive\\Pictures\\garisan.png");
		 Image imageRyan = new Image("C:\\Users\\rezal\\Downloads\\rjs.png");
		 ImageView imgGR = new ImageView(imageGR);
		 ImageView imgRyan = new ImageView(imageRyan);
		 votePane.add(imgRyan, 0, 3);
		 votePane.add(imgGR,1,3);
		 imgRyan.setFitWidth(180);
		 imgRyan.setFitHeight(100);
		 imgGR.setFitWidth(150);
		 imgGR.setFitHeight(100);

		 
		votePane.setAlignment(Pos.CENTER);
		Scene sceneVote = new Scene(votePane,500,400);		


		//set Background Color
		votePane.setStyle("-fx-background-color: black;");
		sceneVote.setFill(Color.BLACK);
		
		
		//if correct at verify scene will take to voting scene
		Button Correct = new Button("Info Correct");
		Correct.setOnAction(e -> primaryStage.setScene(sceneVote));
		paneVer.add(Correct, 1, 5);

		
		//Postvote Scene
		GridPane postPane = new GridPane();
		
		Scene postVote = new Scene(postPane,500,400);
		
		//create image when done voting
		votePane.add(doneVote, 1,4);
		doneVote.setOnAction(e -> {
			
			
			
			//tambah vote dalam database
			if(voteSyaidi.isSelected()){
				try {  
					int candidateId = 1;
				
					Statement addVoteStatement = connection.createStatement();
					addVoteStatement.executeUpdate("update candidate set votecount = votecount + 1 where candidateid = '" + candidateId + "'");
					System.out.println("Vote for CandidateId " + candidateId + " is added 1 ");
					
					Statement voteNowStatement = connection.createStatement();
					ResultSet voteNowResultSet = voteNowStatement.executeQuery("select Name, VoteCount from voters natural join candidate where candidateid = '" + candidateId + "'");
					
					if(voteNowResultSet.next()){
						System.out.println("Vote for " + voteNowResultSet.getString(1) + " is now " + voteNowResultSet.getString(2));
					}
					
				} catch (Exception ex){
					ex.printStackTrace();
				}
				
			} else if(voteNeyman.isSelected()){
				try { 
					int candidateId = 2;
				
					Statement addVoteStatement = connection.createStatement();
					addVoteStatement.executeUpdate("update candidate set votecount = votecount + 1 where candidateid = '" + candidateId + "'");
					System.out.println("Vote for CandidateId " + candidateId + " is added 1 ");

					Statement voteNowStatement = connection.createStatement();
					ResultSet voteNowResultSet = voteNowStatement.executeQuery("select Name, VoteCount from voters natural join candidate where candidateid = '" + candidateId + "'");
					
					if(voteNowResultSet.next()){
						System.out.println("Vote for " + voteNowResultSet.getString(1) + " is now " + voteNowResultSet.getString(2));
					}
					
				} catch (Exception ex){
					ex.printStackTrace();
				}
				
			} else if(voteRyan.isSelected()){
				try { 
					int candidateId = 3;
				
					Statement addVoteStatement = connection.createStatement();
					addVoteStatement.executeUpdate("update candidate set votecount = votecount + 1 where candidateid = '" + candidateId + "'");
					System.out.println("Vote for CandidateId " + candidateId + " is added 1 ");

					Statement voteNowStatement = connection.createStatement();
					ResultSet voteNowResultSet = voteNowStatement.executeQuery("select Name, VoteCount from voters natural join candidate where candidateid = '" + candidateId + "'");
					
					if(voteNowResultSet.next()){
						System.out.println("Vote for " + voteNowResultSet.getString(1) + " is now " + voteNowResultSet.getString(2));
					}
				
				} catch (Exception ex){
					ex.printStackTrace();
				}
			}
			
			try{
				Statement compareStatement = connection.createStatement();
				ResultSet compareResultSet = compareStatement.executeQuery("select votecount from candidate");
			
				int a = 0, b = 0, c= 0;
				int counter = 0;
				int large = 0;
			
				while(compareResultSet.next()){
					if(counter == 0){
						a = compareResultSet.getInt(1);
					}
					if(counter == 1){
						b = compareResultSet.getInt(1);
					}
					if(counter == 2){
						c = compareResultSet.getInt(1);
					}
					counter++;
				}
			
				if(a > b && a > c)
         			large = a;
      			else if(b > a && b > c)
         			large = b;
      			else
         			large = c;
         	
         	Statement reupdateStatement = connection.createStatement();
			reupdateStatement.executeUpdate("update candidate set status = 'NOT WIN'");	
			
			Statement updateWinnerStatement = connection.createStatement();
			updateWinnerStatement.executeUpdate("update candidate set status = 'WIN' where votecount = '" + large + "'");
			
			Statement updateVoteStatusStatement = connection.createStatement();
			updateVoteStatusStatement.executeUpdate("UPDATE voters set VoteCheck = 'VOTED' where matricNo = '" + matricNo + "'");
         			
			} catch(Exception exc){
				exc.printStackTrace();
			}
			
			//tukar kepada scene terima kasih
			primaryStage.setScene(postVote);
			});
			
		Image vut = new Image("D:\\trimas.png");
	    ImageView imageVut = new ImageView(vut);
	    //add imageView to your scene or layout
	    imageVut.setFitWidth(450);
	    imageVut.setFitHeight(350);
	    postPane.add(imageVut, 0, 0);
		
		
		
		//Admin login Scene
		TextField tfUsernameAdm = new TextField();
		PasswordField tfPasswordAdm = new PasswordField();
		Button btLoginAdm = new Button("Login");
		TextField failedAdm = new TextField();
		Image imageUPMAdm = new Image("D:\\logoupm.jpg");
		ImageView imgUPMAdm = new ImageView(imageUPM);
				
		
		//initialize pane and add to pane
		GridPane paneLoginAdm = new GridPane();
		paneLoginAdm.setHgap(5);
		paneLoginAdm.setVgap(5);
		
		paneLoginAdm.add(imgUPMAdm, 1, 0);
		imgUPMAdm.setFitWidth(100);
		imgUPMAdm.setFitHeight(60);
		paneLoginAdm.add(new Label("Username: "), 0, 1);
		paneLoginAdm.add(tfUsernameAdm, 1, 1);
		
		paneLoginAdm.add(new Label("Password: "), 0, 2);
		paneLoginAdm.add(tfPasswordAdm, 1, 2);
		
		paneLoginAdm.add(btLoginAdm, 1, 3);
		final Text actionTarget1 = new Text();
		paneLoginAdm.add(actionTarget1,0,3);
		
		paneLoginAdm.setAlignment(Pos.CENTER);
		
		Scene sceneLoginAdm = new Scene(paneLoginAdm,400,250);
		paneLoginAdm.setStyle("-fx-background-color: #C8234A;");

		
		
		
		//Registered Voter Scene 


		//initialize pane and add to scene
		
		
		

		
		//Choose User type Scene
		GridPane paneChoose = new GridPane();

		Button chooseVoters = new Button("Voters");
		chooseVoters.setOnAction(e -> primaryStage.setScene(sceneLogin));
		paneChoose.add(chooseVoters, 0, 1);
				
		Button chooseAdmin = new Button("Admin");
		chooseAdmin.setOnAction(e -> primaryStage.setScene(sceneLoginAdm));
		
		paneChoose.add(chooseAdmin, 2, 1);
		paneChoose.setAlignment(Pos.CENTER);
		
		
		Image imageUPM1 = new Image("D:\\logoupm.jpg");
		ImageView imgUPM1 = new ImageView(imageUPM1);
		paneChoose.add(imgUPM1, 1, 0);
		
		imgUPM1.setFitWidth(100);
		imgUPM1.setFitHeight(60);
		
		paneChoose.setHgap(10);
		paneChoose.setVgap(10);

		
		Scene sceneChoose = new Scene(paneChoose,400,250);
		
		paneChoose.setStyle("-fx-background-color: #C8234A;");
		
		
		//Primary Stage Set
		primaryStage.setTitle("Putra Voting");
		primaryStage.setScene((sceneChoose));
		primaryStage.show();
		
		
		//button if click and correct will take to next scene 
		btLogin.setOnAction(event -> {
			
			
			try {
				Statement statementLogin = connection.createStatement();
				
				ResultSet resultSetLogin = statementLogin.executeQuery("select MatricNo, Name, VotersPassword, VoteCheck from voters where MatricNo = '" + tfMatricNo.getText() + "'");
					
				while(resultSetLogin.next()) {
					System.out.println(resultSetLogin.getString(1) + " " + resultSetLogin.getString(2) + " " + resultSetLogin.getString(3));
						
					String inputtedMatricNo = tfMatricNo.getText();
					String availableMatricNo = resultSetLogin.getString(1);
					String inputtedPassword = tfPassword.getText();
					String availablePassword = resultSetLogin.getString(3);
					String voteStatus = resultSetLogin.getString(4);
					
					
						
					if(availableMatricNo.equals(inputtedMatricNo) && availablePassword.equals(inputtedPassword)) {
						matricNo = availableMatricNo;
						if (voteStatus.equals("VOTED"))
						{
							//Already voted
							actionTarget.setText("Already voted");
						}
						
						else
						{
							try {
							Statement statementVerify = connection.createStatement();
							
							ResultSet resultSetVerify = statementVerify.executeQuery("select Name, MatricNo, FacultyName, CollegeName from voters natural join (faculty, college) where matricNo = '" + matricNo + "'");
								
							while(resultSetVerify.next()) {
								System.out.println(resultSetVerify.getString(1) + " " + resultSetVerify.getString(2) + " " + resultSetVerify.getString(3) + " " + resultSetVerify.getString(4));
						
								tfName.setText(resultSetVerify.getString(1));
								tMatricVer.setText(resultSetVerify.getString(2));
								tfFaculty.setText(resultSetVerify.getString(3));
								tfCollege.setText(resultSetVerify.getString(4));
							}
							} catch (Exception e) {
								e.printStackTrace();
							}
						primaryStage.setScene(sceneVerify);
						}
						
					} 
						
					
					else
					{
						//Login failed
						actionTarget.setText("Incorrect");	
					}
					
				} 
			}catch (Exception e) {
				e.printStackTrace();
			}
			
				
					
			/*
			 * Pair<String, String> credentials =
			 * readCredentialsFromFile("C:\\Users\\User\\Downloads\\credentials.txt.txt");
			 * String correctUsername = credentials.getKey(); String correctPassword =
			 * credentials.getValue();
			 * 
			 * if (tfMatricNo.getText().equals(correctUsername) &&
			 * tfPassword.getText().equals(correctPassword)) {
			 * primaryStage.setScene(sceneVerify); } else { //Login failed
			 * actionTarget.setText("Incorrect!"); }
			 */
			
		});
		
		paneVer.setAlignment(Pos.CENTER);
		
		//admin navigating scene
		GridPane paneNavigation = new GridPane();
		paneNavigation.setHgap(5);
		paneNavigation.setVgap(5);
		
		Button votersCheckBt = new Button("Voters Table Check");
		Button voteCheckBt = new Button("Vote Check");
		paneNavigation.setAlignment(Pos.CENTER);
		
		paneNavigation.add(votersCheckBt, 0, 0);
		paneNavigation.add(voteCheckBt, 0, 1);
		
		
		Scene sceneNavigation = new Scene(paneNavigation,400,250);
		
		btLoginAdm.setOnAction(event -> {
			
			 try {
				Statement statementLoginAdm = connection.createStatement();
				
				ResultSet resultSetLoginAdm = statementLoginAdm.executeQuery("select AdminUsername, AdminPassword from admin where AdminUsername = '" + tfUsernameAdm.getText() + "'");
					
				while(resultSetLoginAdm.next()) {
					System.out.println(resultSetLoginAdm.getString(1) + " " + resultSetLoginAdm.getString(2));
					System.out.println(tfUsernameAdm.getText() + " " + tfPasswordAdm.getText());
						
					String inputtedUsername = tfUsernameAdm.getText();
					String availableUsername = resultSetLoginAdm.getString(1);
					String inputtedPassword = tfPasswordAdm.getText();
					String availablePassword = resultSetLoginAdm.getString(2);
						
					if(availableUsername.equals(inputtedUsername) && availablePassword.equals(inputtedPassword)) {
						primaryStage.setScene(sceneNavigation);
					} else {
						System.out.println("Incorrect");
					}
					
				} 
			}catch (Exception e) {
				e.printStackTrace();
			}
			/*
			 * Pair<String, String> credentials =
			 * readCredentialsFromFile("C:\\Users\\User\\Downloads\\credentials.txt.txt");
			 * String correctUsername = credentials.getKey(); String correctPassword =
			 * credentials.getValue();
			 * 
			 * if (tfMatricNoAdm.getText().equals(correctUsername) &&
			 * tfPasswordAdm.getText().equals(correctPassword)) {
			 * primaryStage.setScene(sceneNavigation); } else { //Login failed
			 * actionTarget.setText("Incorrect!"); }
			 */
			
		});
        
		GridPane votersCheckPane = new GridPane();
		
		Statement tableSt = connection.createStatement();
		ResultSet tableRs = tableSt.executeQuery("SELECT MatricNo, Name, FacultyName, CollegeName, VoteCheck FROM voters NATURAL JOIN (faculty, college)");
		votersCheckPane.add(new Label("MatricNo" + "		"), 0, 1);
				votersCheckPane.add(new Label("Name" + "		"), 1, 1);
				votersCheckPane.add(new Label("Faculty" + "		"), 2, 1);
				votersCheckPane.add(new Label("College" + "		"), 3, 1);
				votersCheckPane.add(new Label("Vote Check"), 4, 1);
				
		int i = 2;
		while(tableRs.next())
		{
				
				votersCheckPane.add(new Label(tableRs.getString(1) + "		"), 0, i);
				votersCheckPane.add(new Label(tableRs.getString(2) + "		"), 1, i);
				votersCheckPane.add(new Label(tableRs.getString(3) + "		"), 2, i);
				votersCheckPane.add(new Label(tableRs.getString(4) + "		"), 3, i);
				votersCheckPane.add(new Label(tableRs.getString(5)), 4, i);
		
			i++;
		}
        
        Scene votersCheckScene = new Scene(votersCheckPane);
		
		votersCheckBt.setOnAction(e -> {
			primaryStage.setScene(votersCheckScene);
		});
		
		GridPane voteCheckPane = new GridPane();
		
		Statement table2St = connection.createStatement();
		ResultSet table2Rs = table2St.executeQuery("SELECT MatricNo, CandidateId, PartyName, Name, VoteCount, Status FROM candidate NATURAL JOIN (voters, party)");
		
		int j = 1;
		
		voteCheckPane.add(new Label("MatricNo" + "		"), 0, j);
		voteCheckPane.add(new Label("Candidate Id" + "		"), 1, j);
		voteCheckPane.add(new Label("Party" + "		"), 2, j);
		voteCheckPane.add(new Label("Name" + "		"), 3, j);
		voteCheckPane.add(new Label("Vote Count" + "		"), 4, j);
		voteCheckPane.add(new Label("Status" + "		"), 5, j);	
		j++;
		
		while(table2Rs.next())
		{	
			voteCheckPane.add(new Label(table2Rs.getString(1) + "		"), 0, j);
			voteCheckPane.add(new Label(table2Rs.getString(2) + "		"), 1, j);
			voteCheckPane.add(new Label(table2Rs.getString(3) + "		"), 2, j);
			voteCheckPane.add(new Label(table2Rs.getString(4) + "		"), 3, j);
			voteCheckPane.add(new Label(table2Rs.getString(5) + "       "), 4, j);
			voteCheckPane.add(new Label(table2Rs.getString(6)), 5, j);
			j++;	
		}
        
        Scene voteCheckScene = new Scene(voteCheckPane);
        
		voteCheckBt.setOnAction(e -> {
			primaryStage.setScene(voteCheckScene);
		});
		
		Button backFromTable = new Button("Back");
		Button backFromCandidate = new Button("Back");
		Button logOutButton = new Button("Log Out");
		Button homePageButton1 = new Button("Back");
		Button homePageButton2 = new Button("Back");
		Button homePageButton3 = new Button("Back");
		
		votersCheckPane.add(backFromTable, 0, 0);
		voteCheckPane.add(backFromCandidate, 0, 0);
		paneNavigation.add(logOutButton, 0, 2);
		paneLoginAdm.add(homePageButton1, 1, 4);
		paneLogin.add(homePageButton2, 1, 4);
		//postPane.add(homePageButton3, 0, 1);
		
		backFromTable.setOnAction(e -> {
			primaryStage.setScene(sceneNavigation);
		});
		
		backFromCandidate.setOnAction(e -> {
			primaryStage.setScene(sceneNavigation);
		});
		
		logOutButton.setOnAction(e -> {
			primaryStage.setScene(sceneLoginAdm);
		});
		
		homePageButton1.setOnAction(e ->{
			primaryStage.setScene(sceneChoose);
		});
		
		homePageButton2.setOnAction(e ->{
			primaryStage.setScene(sceneChoose);
		});
		
		/*
		homePageButton3.setOnAction(e ->{
			primaryStage.setScene(sceneChoose);
		});
		*/
	}
	
	/*
	
	private Pair<String,String> readCredentialsFromFile(String fileName){
		 try {
			 	//Read from file
			    BufferedReader reader = new BufferedReader(new FileReader(fileName));
			    
			    //split by comma(Username,Password);
			    String[] credentials = reader.readLine().split(",");
			    String username = credentials[0];
			    String password = credentials[1];
			    reader.close();
			    return new Pair<>(username, password);
			  } catch (IOException e) {
			    // File not found or error reading the file
			    return new Pair<>(null, null);
			  }
	}
	*/


	
public static void main(String[] args) { 
    launch(args);
  }
  
	
}
