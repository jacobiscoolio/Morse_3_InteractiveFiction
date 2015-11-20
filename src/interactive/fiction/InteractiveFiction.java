package interactive.fiction;

import java.util.Scanner;

public class InteractiveFiction {

    static boolean goodanswer = false;
    static boolean oldman1 = false;
    static boolean bandit = false;
    static boolean oldman2 = false;
    static boolean flamer = false;
    static boolean oldman3 = false;
    static boolean childrenofthecorn = false;
static boolean youwin = false;
    static int hero = 0;
    //#hero
    static int water = 1;
    //#hero
    static double bandito = .5;
    //#enemy object
    static double flamers = 2.5;
    //#enemy object
    public static void main(String[] args) {
        //#while
        //Makes sure game continues until you win
        while (youwin == false){
        intro();
        scene2();
        scene3();
        scene4();
        scene5();
        scene6();
        scene7();
        }
        }
//#method 1
    static void intro() {
        System.out.println("The year is 2058. It has been 28 years since the great drought dried up most of the water in the world and burned the crops. ");
        System.out.println("The world is a desolate desert with only a sparse amount of water to share between the multitude of villages and tribes that need it.  ");
        System.out.println("You have just traded your villages funds to get a bag of the Miracle Seed, a seed that supposedly needs no water, and thrives on the vast heat of the sun.");
        System.out.println("You are your villages last hope, and all you have is a small bottle of water, some bandages, and the clothes on your back. Can you make it?");
        System.out.println("As you walk back to your village, you pass a short old man wearing a black robe. He offers you a dagger, a valuable tool in this dangerous bandit infested wasteland.");
        System.out.println("All he wants is a handful of your Miracle Seeds. You could make the trade, or Deny it?");

        Scanner intro = new Scanner(System.in);
        String a = intro.nextLine().toLowerCase();
//Asks the user for a choice
        if (a.contains("trade")) {
            oldman1 = true;
            hero++;
            //Gives more attack stat to hero 
            System.out.println("You make the trade, and continue on your path. As you look back you no longer see the old man.");
            System.out.println("You wonder if the heat was playing tricks on your mind, but regardless, you continue on, hoping you didn't make a terrible mistake.");
        } else if (a.contains("deny")) {
            System.out.println("You make the trade, and continue on your path. As you look back you no longer see the old man.");
            System.out.println("You wonder if the heat was playing tricks on your mind, but regardless, you continue on, hoping you didn't make a terrible mistake.");
            oldman1 = true;
        } else {
            System.out.println("Not a valid answer. You can trade or deny.");
            intro();
        }

    }
//#method 2
    static void scene2() {
        if (oldman1 == true) {

            System.out.println("As you continue on, a group of bandits jump out of no where and demand you give them your water. You can attack or give them your water. What do you do?");
            Scanner scene2 = new Scanner(System.in);
            String b = scene2.nextLine().toLowerCase();
            if (b.contains("attack")) {
                if (hero > bandito) {
                    bandit = true;
                    hero++;
                    hero++;
                    water++;
                    //Gives some water to hero
                    System.out.println("You pull out your dagger and get ready for a fight, but before your first strike, the bandits run off, dropping other things they stole from previous travelers.");
                    System.out.println("You pick up a water canteen, an apple, and equip some leather armor.");
                } else {
                    System.out.println("You charge the bandits with your fists, but you didn't have a chance. They kill you and take your things. You have failed your village, and yourself.");
                    System.out.println("you Lose.");
                    System.out.println("");
                    System.out.println("");
                    hero = 0;
                    water = 1;
//#lose
                }

            } else if (b.contains("give")) {
                System.out.println("You give them the water that they ask for. They run off, probably to find their next victim.");
                bandit = true;
                water--;
            } else {
                System.out.println("Not a valid answer. You can attack or give.");
                scene2();
            }

        }
    }
//#method 3
    static void scene3() {
        if (bandit == true) {
            System.out.println("You continue on your path, and you see the same old man you gave the seeds to.");
            System.out.println("He asks you for water, but he has nothing to offer. You could either could leave him to his fate, or offer him your some water. What do you do? ");
            Scanner scene3 = new Scanner(System.in);
            String c = scene3.nextLine().toLowerCase();
            if (c.contains("offer")) {
                if (water > 0) {
                    oldman2 = true;
                    System.out.println("You pity the man, and give him your recently obtained canteen. He runs off joyful of your selfless deed.");
                    water--;
                } else {
                    System.out.println("You reach for your water, but you don't have any to offer. He realizes that you are not capable of giving him water, and walks away.");
                    oldman2 = true;
                }
            } else if (c.contains("leave")) {
                System.out.println("You tell the man that what you have is your own, and that you cant afford to spare any of it.");
                oldman2 = true;
            } else {
                System.out.println("Not a valid answer. You can leave or offer.");
                scene3();
            }

        }
    }
//#method 4
    static void scene4() {
        if (oldman2 == true) {

            System.out.println("As you continue, a local group of blood-crazed bandits, the flamers, start to run toward you.");
            System.out.println("What will you do, hope to run away, or stand your ground and fight?");
            Scanner scene4 = new Scanner(System.in);
            String d = scene4.nextLine().toLowerCase();
            if (d.contains("fight")) {
                if (water == 2) {
                    System.out.println("As you charge them, they spray fire towards you. As soon as it touches your canteen, it explodes and burns you alive.");
                //#lose
                    System.out.println("You Lose.");
                    System.out.println("");
                    System.out.println("");
                    water = 1;
                    hero = 0;
                } else if (hero < flamers) {
                    System.out.println("You charge them, but their equpiment and numbers are too much for you to handle. You collapse to the floor, a burnt husk of your former self. ");
                   System.out.println("You Lose.");
                   System.out.println("");
                   System.out.println("");
                    water = 1;
                    hero = 0;
                    
//#lose
                } else {
                    System.out.println("You draw your dagger and charge the bandits without fear. They blast you with their destructive flames, but your leather armor catches flame instead of your skin.");
                    System.out.println("You take off the burning armor and throw it at the gasoline leaking from their flame throwers. They catch fire and run off, trying to stay alive.");
                    System.out.println("Their isn't anything usable, so you continue to walk to your village. You check your inventory, making sure all your items aren't charred, but it looks as though everything is fine.");
                    flamer = true;
                }

            } else if (d.contains("run")) {
                if (water == 2) {
                    System.out.println("You run straight through them as they shoot flames at you, but as soon as the flames hit your canteen, it explodes and burns you alive. ");
                    System.out.println("You lose");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    hero = 0;
                    water = 1;
//#lose
                } else {
                    System.out.println("You run straight through them as they shoot falmes at you. You catch on fire, but you take the pain and keep running. You get away with some minor burns");
                    System.out.println("You check your inventory, making sure all your items aren't charred, but it looks as though everything is fine.");
                    flamer = true;
                }

            } else {
                System.out.println("Not a valid answer. You can fight or run.");
                scene4();
            }

        }
    }
//#method 5
    static void scene5() {
        // Only works if user has completed the flamer encounter
        if (flamer == true) {

            System.out.println("As you walk to your village, you again see the old man, but he is lying face down in the sand. He is alive, but he will surely die if he is left like this.");
            System.out.println("You could either leave him to his fate, or take him with you. What do you do?");
            Scanner scene5 = new Scanner(System.in);
            String e = scene5.nextLine().toLowerCase();
            if (e.contains("leave")) {

                System.out.println("You think about it, but your village is your first priority. You leave him to his fate, which is death.");
                abandonscene();
            } else if (e.contains("take")) {
                oldman3 = true;
            } else {
                System.out.println("Not a valid answer. You can take or leave.");
                scene5();
            }

        }

    }
//#method 6
    static void abandonscene() {

        System.out.println("You are now approaching your village, but you notice men with guns surrounding your village. You have one final decision.");
        System.out.println("You can go to your village and try to help, or leave them, and live your life as a wanderer");
        Scanner abandoner = new Scanner(System.in);
        String h = abandoner.nextLine();
        if (h.contains("help")) {
            System.out.println("You go to your village, but the men rush you before you can get their. They ask where their leader is and threaten to destroy your village if you don't cooperate.");
            System.out.println("You ask them what he looks like, and they describe the old man you left. You tell them of his fate, and they become enraged.");
            System.out.println("They destroy your village and kill all of the citizens. They shoot you in the legs and force you to watch all of it unfold until you bleed out.");
            System.out.println("You lose.");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            hero = 0;
            water = 1;
//#lose
        } else if (h.contains("leave")) {
            System.out.println("You leave your village and wander the desert. You live a hard but long life, but you never find out what happened to your village.");
            System.out.println("You win.");
            youwin = true;
            //#win
        } else {
            System.out.println("Not a valid answer. You can help or leave.");
            abandonscene();
        }

    }
//#method 7
    static void scene6() {
        if (oldman3 == true) {
            System.out.println("You pick him up and raise him to your back. You can smell the alcohol on his breath, he is obviously wasted. You wonder how he got alcohol out here.");
            System.out.println("As you struggle to carry this old man to your village, a group of children, covered in dirt and dried blood , walk up to you. They tell you that the oldman is their grandfather, and they will take him back to their home.");
            System.out.println("The oldman wakes up, but doesn't seem to know who these kids are. The children say he has alzheimers,which would explain why he seems to eb clueless.  ");
            System.out.println("You can give them the oldman, or refuse, and take him to your village. What do you do?");
            Scanner scene6 = new Scanner(System.in);
            String f = scene6.nextLine();
            if (f.contains("refuse")) {
                childrenofthecorn = true;
            } else if (f.contains("give")) {

                System.out.println("You trust the children and give the old man to the kids. Their is a bit of a struggle, but they eventuall take him back to their home, wherever that is.");
                abandonscene();
            } else {
                System.out.println("Not a valid answer. You can refuse or give.");
                scene6();
            }

        }
    }
//#method 8
    static void scene7() {
        if (childrenofthecorn == true) {
            System.out.println("You don't trust these children, so you refuse to give them the old man. They didn't really like your response, and pull out knives and try to stab you. ");
            System.out.println("You cant really fight with this man on your back, so you run, you run as fast you can. They aren't to fast so you easily escape them.");
            System.out.println("The old man explains to you that children without parents in this wasteland find that cannabilism is a much easier option then finding other food.");
            System.out.println("As you approach your village, the old man signals you to stop. He tells you that he isn't just some old man, but the leader of a massive outpost to the north.");
            System.out.println("He explains to you that he needs someone like you to lead his militia. You would bring the seeds to your people, and then leave them forever. They would be protected and live peacfully for the foreseeable future.");
            System.out.println("So what do you do, agree to this old man you barely know, or stay with your village and deny the offer?");
            Scanner scene7 = new Scanner(System.in);
            String g = scene7.nextLine().toLowerCase();
            if (g.contains("deny")) {
                System.out.println("You are honored by his offer, but you can't. This village is your home, and nothing can keep it away from you.");
                System.out.println("You bring the seeds to your village. The villagers are ecsatitic, and can now have a chance in surviving the post apocolyptic wasteland.");
                System.out.println("You win!");
                youwin = true;
//#win
            } else if (g.contains("agree")) {
                System.out.println("You put your village before yourself, and agree to lead this mans militia. You give your village the seeds, say your goodbyes, and head towards the outpost.");
                System.out.println("Your village lives peacfully with the protection of these strangers, and you live a long life as a general.");
                System.out.println("You Win!!!!");
                youwin = true;
                
            } else {
                System.out.println("Not a valid answer. You can agree or deny.");
                scene7();
            }

            }
        }
    }

