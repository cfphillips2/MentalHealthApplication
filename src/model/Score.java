package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.eclipse.persistence.jpa.jpql.parser.DateTime;


@Entity
@Table(name="scores")
public class Score {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int idScore;
	
	@Column
	private int score;
	
	@Column
	private DateTime date;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idUser")
	private int idUser;
	
	//Default Constructor
	public Score() {
		
	}
	
	//Constructor
	public Score(int score, int idUser) {
		this.score = score;
		this.idUser = idUser;
	}

	public int getIdScore() {
		return idScore;
	}

	public void setIdScore(int idScore) {
		this.idScore = idScore;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public DateTime getDate() {
		return date;
	}

	public void setDate(DateTime date) {
		this.date = date;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
	public String returnScoreDetails() {
		return date + ": " + score + ", " + idUser;
		
	}
	
	

}
