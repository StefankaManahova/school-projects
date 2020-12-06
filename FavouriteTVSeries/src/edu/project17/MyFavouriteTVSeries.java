package edu.project17;

public class MyFavouriteTVSeries {

	public static void main(String[] args) {
		Collection myCollection = new Collection();
		myCollection.name = "Fany's collection of TV series";
		
		TVSeries sherlock = new TVSeries(4);
		sherlock.name = "Sherlock";
		myCollection.tvSeries.add(sherlock);
		
		Character sherlockHolmes = new Character();
		sherlockHolmes.name = "Sherlock Holmes";
		sherlockHolmes.description = "the famous detective with brilliant deduction skills";
		sherlock.characters.add(sherlockHolmes);
		
		Actor benedict = new Actor();
		benedict.name = "Benedict Cumberbatch";
		benedict.characters.add(sherlockHolmes);
		sherlockHolmes.actor.add(benedict);
		
			
		Character watson = new Character();
		watson.name = "John Watson";
		watson.description = "Sherlock's best friend and crime-solving partner";
		sherlock.characters.add(watson);
		
		Actor martin = new Actor();
		martin.name = "Martin Freeman";
		martin.characters.add(watson);
		watson.actor.add(martin);
		
		
		Character moriarty = new Character();
		moriarty.name = "Jim Moriarty";
		moriarty.description = "a criminal mastermind who wants to destroy Sherlock";
		sherlock.characters.add(moriarty);
		
		Actor andrew = new Actor();
		andrew.name = "Andrew Scott";
		andrew.characters.add(moriarty);
		moriarty.actor.add(andrew);
		
		
		Character lestrade = new Character();
		lestrade.name = "Greg Lestrade";
		lestrade.description = "an inspector from Scotland Yard";
		sherlock.characters.add(lestrade);
		
		Actor rupertGraves = new Actor();
		rupertGraves.name = "Rupert Graves";
		rupertGraves.characters.add(lestrade);
		lestrade.actor.add(rupertGraves);
		
		
		Character mrsH = new Character();
		mrsH.name = "Mrs. Hudson";
		mrsH.description = "Sherlock and John's landlady";
		sherlock.characters.add(mrsH);
		
		Actor una = new Actor();
		una.name = "Una Stubbs";
		una.characters.add(mrsH);
		mrsH.actor.add(una);
		
		
		Character mycroft = new Character();
		mycroft.name = "Mycroft Holmes";
		mycroft.description = "Sherlock's antisocial brother";
		sherlock.characters.add(mycroft);
		
		Actor markGatiss = new Actor();
		markGatiss.name = "Mark Gatiss";
		markGatiss.characters.add(mycroft);
		mycroft.actor.add(markGatiss);
		
		//System.out.println(sherlock.toString());
		
		
		
		
		TVSeries bbcMerlin = new TVSeries(5);
		bbcMerlin.name = "Merlin";
		myCollection.tvSeries.add(bbcMerlin);
		
		Character merlin = new Character();
		merlin.name = "Merlin";
		merlin.description = "a young and adorable sorcerer whose destiny is to protect Arthur";
		bbcMerlin.characters.add(merlin);
		
		Actor colin = new Actor();
		colin.name = "Colin Morgan";
		colin.characters.add(merlin);
		merlin.actor.add(colin);
		
		
		Character arthur = new Character();
		arthur.name = "Arthur Pendragon";
		arthur.description = "the king of Camelot and Merlin's best friend";
		bbcMerlin.characters.add(arthur);
		
		Actor bradley = new Actor();
		bradley.name = "Bradley James";
		bradley.characters.add(arthur);
		arthur.actor.add(bradley);
		
		
		
		Character morgana = new Character();
		morgana.name = "Morgana Pendragon";
		morgana.description = "Arthur's sister who has magical abilities";
		bbcMerlin.characters.add(morgana);
		
		Actor katie = new Actor();
		katie.name = "Katie McGrath";
		katie.characters.add(morgana);
		morgana.actor.add(katie);
		
		
		Character gaius = new Character();
		gaius.name = "Gaius";
		gaius.description = "Camelot's court physician and Merlin's mentor";
		bbcMerlin.characters.add(gaius);
		
		Actor richardWilson = new Actor();
		richardWilson.name= "Richard Wilson";
		richardWilson.characters.add(gaius);
		gaius.actor.add(richardWilson);
		
				
		Character lancelot = new Character();
		lancelot.name = "Sir Lancelot";
		lancelot.description = "a brave knight of the round table and a close friend of Merlin";
		bbcMerlin.characters.add(lancelot);
		
		Actor santiago = new Actor();
		santiago.name = "Santiago Cabrera";
		santiago.characters.add(lancelot);
		lancelot.actor.add(santiago);
		
		
		Character leon = new Character();
		leon.name = "Sir Leon";
		leon.description = "an immortal knight of the round table";
		bbcMerlin.characters.add(leon);
		
		Actor rupertYoung = new Actor();
		rupertYoung.name = "Rupert Young";
		rupertYoung.characters.add(leon);
		leon.actor.add(rupertYoung);
		
		
		Character gwaine = new Character();
		gwaine.name = "Sir Gwaine";
		gwaine.description = "a knight of the round table who enjoys flirting and drinking";
		bbcMerlin.characters.add(gwaine);
		
		Actor eoin = new Actor();
		eoin.name = "Eoin Macken";
		eoin.characters.add(gwaine);
		gwaine.actor.add(eoin);
		
		
		Character percival = new Character();
		percival.name = "Sir Percival";
		percival.description = "a very strong knight of the round table";
		bbcMerlin.characters.add(percival);
		
		Actor tom = new Actor();
		tom.name = "Tom Hopper";
		tom.characters.add(percival);
		percival.actor.add(tom);
		
		
		Character dragon = new Character();
		dragon.name = "The Great Dragon";
		dragon.description = "the last dragon in Camelot and an advisor to Merlin, although often unhelpful";
		bbcMerlin.characters.add(dragon);
		
		Actor johnHurt = new Actor();
		johnHurt.name = "John Hurt";
		johnHurt.characters.add(dragon);
		dragon.actor.add(johnHurt);
		
		//System.out.println(bbcMerlin.toString());
		
		
		
		TVSeries doctorWho = new TVSeries(12);
		doctorWho.name = "Doctor Who";
		myCollection.tvSeries.add(doctorWho);
		
		Character doctor = new Character();
		doctor.name = "The Doctor";
		doctor.description = "a timelord from Gallifrey who can travel anywhere in time and space with his TARDIS";
		doctorWho.characters.add(doctor);
		
		doctor.actor.add(johnHurt);
		johnHurt.characters.add(doctor);
		
		Actor chris = new Actor();
		chris.name = "Christopher Eccelston";
		chris.characters.add(doctor);
		doctor.actor.add(chris);
		
		Actor david = new Actor();
		david.name = "David Tennant";
		david.characters.add(doctor);
		doctor.actor.add(david);
		
		Actor matt = new Actor();
		matt.name = "Matt Smith";
		matt.characters.add(doctor);
		doctor.actor.add(matt);
		
		Actor peter = new Actor();
		peter.name = "Peter Capaldi";
		peter.characters.add(doctor);
		doctor.actor.add(peter);
		
		
		Character master = new Character();
		master.name = "The Master";
		master.description = "a powerhungry timelord who is the Doctor's oldest friend but often also his enemy";
		doctorWho.characters.add(master);
		
		Actor johnSimm = new Actor();
		johnSimm.name = "John Simm";
		johnSimm.characters.add(master);
		master.actor.add(johnSimm);
		
		
		
	    Character capJack = new Character();
	    capJack.name = "Captain Jack Harkness";
	    capJack.description = "a flirty former time agent who later becomes immortal";
	    doctorWho.characters.add(capJack);
	    
	    Actor johnBarrowman = new Actor();
	    johnBarrowman.name = "John Barrowman";
	    johnBarrowman.characters.add(capJack);
	    capJack.actor.add(johnBarrowman);
	    
	    
	    Character donna = new Character();
	    donna.name = "Donna Noble";
	    donna.description = "a brave woman who travels with the 10th Doctor";
	    doctorWho.characters.add(donna);
	    
	    Actor catherine = new Actor();
	    catherine.name = "Catherine Tate";
	    catherine.characters.add(donna);
	    donna.actor.add(catherine);
	    
	    
	    Character rory = new Character();
	    rory.name = "Rory Williams/Pond";
	    rory.description = "a young man who travels with the 11th doctor and at one point becomes a plastic centurion for 2000 years :)";
		doctorWho.characters.add(rory);
		
		Actor arthurDarvill = new Actor();
		arthurDarvill.name = "Arthur Darvill";
		arthurDarvill.characters.add(rory);
		rory.actor.add(arthurDarvill);
		
		//System.out.println(doctorWho.toString());
		
		
		
		TVSeries goodOmens = new TVSeries(1);
		goodOmens.name = "Good Omens";
		myCollection.tvSeries.add(goodOmens);
		
		Character crowley = new Character();
		crowley.name = "Crowley";
		crowley.description = "a demon who is Aziraphale's best friend and loves the music of Queen";
		goodOmens.characters.add(crowley);
		
		david.characters.add(crowley);
		crowley.actor.add(david);
		
		Character aziraphale = new Character();
		aziraphale.name = "Aziraphale";
		aziraphale.description = "an angel who is Crowley's best friend and owns a bookshop in London";
		goodOmens.characters.add(aziraphale);
		
		Actor michael = new Actor();
		michael.name = "Michael Sheen";
		michael.characters.add(aziraphale);
		aziraphale.actor.add(michael);
		
		
		Character gabriel = new Character();
		gabriel.name = "Archangel Gabriel";
		gabriel.description = "the big boss in Heaven who wants Armageddon to happen so Heaven could defeat Hell once and for all";
		goodOmens.characters.add(gabriel);
		
		Actor johnHamm = new Actor();
		johnHamm.name = "John Hamm";
		johnHamm.characters.add(gabriel);
		gabriel.actor.add(johnHamm);
		
		
		TVSeries musketeers = new TVSeries(3);
		musketeers.name = "The musketeers";
		myCollection.tvSeries.add(musketeers);
		
		Character athos = new Character();
		athos.name = "Athos";
		athos.description = "the moody one out of the main four musketeers";
		musketeers.characters.add(athos);
		
		Actor tomBurke = new Actor();
		tomBurke.name = "Tom Burke";
		tomBurke.characters.add(athos);
		athos.actor.add(tomBurke);
		
		
		Character porthos = new Character();
		porthos.name = "Porthos";
		porthos.description = "the big and strong one out of the main four musketeers";
		musketeers.characters.add(porthos);
		
		Actor howard = new Actor();
		howard.name = "Howard Charles";
		howard.characters.add(porthos);
		porthos.actor.add(howard);
		
		
		Character aramis = new Character();
		aramis.name = "Aramis";
		aramis.description = "the womanizer out of the main four musketeers";
		musketeers.characters.add(aramis);
		
		aramis.actor.add(santiago);
		santiago.characters.add(aramis);
		
		
		Character dartagnan = new Character();
		dartagnan.name = "D'Artagnan";
		dartagnan.description = "the brave young man from Gaskony who joins the trio of musketeers";
		musketeers.characters.add(dartagnan);
		
		Actor luke = new Actor();
		luke.name = "Luke Pasqualino";
		luke.characters.add(dartagnan);
		dartagnan.actor.add(luke);
		
		
		Character louis = new Character();
		louis.name = "King Louis 13th";
		louis.description = "the naive but adorable king";
		musketeers.characters.add(louis);
		
		Actor ryan = new Actor();
		ryan.name = "Ryan Gage";
		ryan.characters.add(louis);
		louis.actor.add(ryan);
		
		
		Character richelieu = new Character();
		richelieu .name = "Richelieu";
		richelieu.description = "the powerhungry cardinal";
		musketeers.characters.add(richelieu);
		
		richelieu.actor.add(peter);
		peter.characters.add(richelieu);
		
		Character rochefort = new Character();
		rochefort.name = "Rochefort";
		rochefort.description = "a spanish spy who manages to manipulate the king";
		musketeers.characters.add(rochefort);

		Actor marc = new Actor();
		marc.name = "Marc Warren";
		marc.characters.add(rochefort);
		rochefort.actor.add(marc);
		
		
		
//		System.out.println(andrew.name+"'s roles:");
//	    for(Character role : andrew.characters) {
//			System.out.println(role.name+", "+ role.description);
//		}
	
//		System.out.println("\n"+peter.name+"'s roles:");
//	    for(Character role : peter.characters) {
//			System.out.println(role.name+", "+ role.description);
//		}
//	    
//		System.out.println("\n"+david.name+"'s roles:");
//	    for(Character role : david.characters) {
//			System.out.println(role.name+", "+ role.description);
//		}
//	    
//		System.out.println("\n"+johnHurt.name+"'s roles:");
//	    for(Character role : johnHurt.characters) {
//			System.out.println(role.name+", "+ role.description);
//		}
//	    
//	    System.out.println("\n\n");
	    
	    System.out.println(myCollection.toString());
       
//        System.out.println("My favourite incarnations of the doctor are played by:"); 
//		for(Actor actor : doctor.actor) {
//			System.out.println(actor.name);
//		}
	}

}
