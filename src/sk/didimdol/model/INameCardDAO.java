package sk.didimdol.model;

import java.util.ArrayList;

public interface INameCardDAO {
	
	void insertNameCard(NameCard card);
	void updateNameCard(NameCard card);
	void deleteNameCard(NameCard card);
	int selectNextId(int id);
	
	NameCard selectNameCard(int id);
	ArrayList<NameCard> selectAllNameCards();
	int selectPreviousId(int searchId);
}
