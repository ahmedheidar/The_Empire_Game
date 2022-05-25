package gui;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import exceptions.FriendlyFireException;
import units.Archer;
import units.Cavalry;
import units.Infantry;
import units.Unit;

public class temple {

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(attack)) {
			int myunit = 0;
			int defunit = 0;

			if (myarmy.getSelectedIndex() != 0 && defendingarmy.getSelectedIndex() != 0) {
				if (army != null) {
					System.out.println("shaghal");
					for (int i = 0; i < army.getUnits().size(); i++) {
						if ((i + 1) == myarmy.getSelectedIndex()) {
							myunit = i;
							System.out.println("myunit " + myunit);
						}
					}
					if ((army.getUnits() != null)) {
						for (int i = 0; i < army.getUnits().size(); i++) {
							if ((i + 1) == defendingarmy.getSelectedIndex()) {
								defunit = i;
								System.out.println("defunit " + defunit);
							}
						}
					}
					Unit me = army.getUnits().get(myunit);
					System.out.println(me.toString());
					Unit def = defendingCity.getDefendingArmy().getUnits().get(defunit);
					System.out.println(def.toString());
					if (!army.getUnits().isEmpty()) {
						if (!defendingCity.getDefendingArmy().getUnits().isEmpty()) {
							if (myflag) {
								try {
									if (me instanceof Archer) {
										((Archer) me).attack(def);
										myflag = false;
									} else if (me instanceof Cavalry) {
										((Cavalry) me).attack(def);
										myflag = false;
									} else {
										((Infantry) me).attack(def);
										myflag = false;
									}
								} catch (FriendlyFireException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							} else {System.out.println("takhalof");
								try {System.out.println("takhalof");
									if (def instanceof Archer) {
										((Archer) def).attack(me);
										myflag = true;
									} else if (def instanceof Cavalry) {
										((Cavalry) def).attack(me);
										myflag = true;
									} else {
										((Infantry) def).attack(me);
										myflag = true;
									}
								} catch (FriendlyFireException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						} else {
							JOptionPane.showConfirmDialog(null, "You Won this Battle !!");
							game.occupy(army, defendingCity.getName());
						}
					} else if (!defendingCity.getDefendingArmy().getUnits().isEmpty()) {
						JOptionPane.showConfirmDialog(null, "You Lost this Battle  '_' ");
					}
				} else {
					System.out.println("mshshaghal");
				}
			} else if (myarmy.getSelectedIndex() != 0 && defendingarmy.getSelectedIndex() == 0) {
				JOptionPane.showConfirmDialog(null, "You Must Choose a Unit from the Defending Army To Attack!");
			} else if (myarmy.getSelectedIndex() == 0 && defendingarmy.getSelectedIndex() != 0) {
				JOptionPane.showConfirmDialog(null, "You Must Choose a Unit from Your Army To Attack!");
			} else {
				JOptionPane.showConfirmDialog(null, "You Must Choose a Unit To Attack!");

			}

		}

	}
}
