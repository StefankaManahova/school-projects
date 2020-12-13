package edu.inheritance;

public class TestPerson {

	public static void main(String[] args) {
		Person ivan = new Person("Ivan",
				                  "Iskar str.",
				                  "0896754675",
				                  "ivan.ivanov@gmail.com");
		
		
		
		Student lily = new Student("Lily",
				                   "Chehov str.",
				                   "0887654392",
				                   "lily.petrova@abv.bg");
		
		lily.setClassStatus(Student.JUNIOR);
		
		
		Employee pesho = new Employee("Pesho",
				                      "Rakovska str.",
				                      "0897659483",
				                      "pesho.igracha@gmail.com",
				                      "Lidl",
				                       1700);	
		
		
		Faculty gosho = new Faculty("Gosho",
				                    "Iskar str.",
				                    "0898383836",
				                    "georgi.slavov@gmail.com",
				                    "SMG",
				                    2100,
				                    "9:00-15:00",
				                    "teacher");
				        
		
		Staff ivo = new Staff("Ivo",
				              "Graff Ignatiev str.",
				              "0887769358",
				              "ivo.minkov@abv.bg",
				              "Hippoland",
				              1800,
				              "shop assistant");
		
		System.out.println(ivan.toString()+"\n");
		System.out.println(lily.toString()+"\n");
		System.out.println(pesho.toString()+"\n");
		System.out.println(gosho.toString()+"\n");
		System.out.println(ivo.toString()+"\n");
	}

}
