package com.edubridge.mixergrinder.model;

import java.util.List;
import java.util.Scanner;
import com.edubridge.mixergrinder.dao.MixerGrinderDaoImpl;

public class App {

	public static void main(String[] args) {
		MixerGrinderDaoImpl dao = new MixerGrinderDaoImpl();
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.println("MY MIXERGRINDER APP");
			System.out.println("--------------");
			System.out.println("1. ADD MIXERGRINDER");
			System.out.println("2. VIEW MIXERGRINDER");
			System.out.println("3. SEARCH MIXERGRINDER");
			System.out.println("4. UPDATE MIXERGRINDER");
			System.out.println("0. EXIT");
			System.out.println("PLEASE CHOOSE OPTION:");
			int option = in.nextInt();

			switch (option) {
			case 1:
				System.out.println("Please enter Company name:");
				String name1 = in.next();
				System.out.println("Please enter Grinder colour:");
				String colour = in.next();
				System.out.println("Please enter Grinder price:");
				long price = in.nextLong();

				MixerGrinder m = new MixerGrinder();
				m.setName(name1);
				m.setColour(colour);
				m.setPrice(price);

				int status = dao.addMixer(m);
				if (status >= 1) {
					System.out.println("New Mixer Saved!!!");
				} else {
					System.out.println("Something is wrong!!!");
				}
				break;
			case 2:
				System.out.println("MixerGrinder List");
				System.out.println("-------------");
				List<MixerGrinder> mixer = dao.getAllMixer();
				if (mixer.size() != 0) {
					for (MixerGrinder MG : mixer) {
						System.out.println(((MixerGrinder) MG).getId() + "\t" + ((MixerGrinder) MG).getName() + "\t"
								+ ((MixerGrinder) MG).getColour() + "\t" + ((MixerGrinder) MG).getPrice());
					}
				} else {
					System.out.println("no mixer found");
				}
				break;

			case 3:
				System.out.println("Please enter name to search:");
				String name = in.next();
				MixerGrinder mixer1 = dao.searchMixer(name);
				if (mixer1 != null) {
					{
						System.out.println(mixer1.getId() + "\t" + mixer1.getName() + "\t" + mixer1.getColour() + "\t"
								+ mixer1.getPrice());
					}
				} else {
					System.out.println("No mixer found");
				}
				break;

			case 4:

				System.out.println("Please enter the name of the mixer to update:");
				String updateName = in.next();
				MixerGrinder existingMixerGrinder = dao.searchMixer(updateName);
				if (existingMixerGrinder != null) {
					System.out.println("Enter new colour:");
					String newColour = in.next();
					System.out.println("Enter new Price:");
					Long newPrice = in.nextLong();

					existingMixerGrinder.setColour(newColour);
					existingMixerGrinder.setPrice(newPrice);

					int updateStatus = dao.updateMixer(existingMixerGrinder);
					if (updateStatus >= 1) {
						System.out.println("MixerGrinder updated successfully!");
					} else {
						System.out.println("Update failed.");
					}
				} else {
					System.out.println("Mixer not found.");
				}
				break;

			case 0:
				System.out.println("Bye!!");
				System.exit(0);
			default:
				System.out.println("Invalid Option!!!");
				break;
		
			}
		}
	}
}
