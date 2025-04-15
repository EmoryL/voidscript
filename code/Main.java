import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    Input input = new Input();
    
    System.out.print("\033[?25l"); //Hide cursor
    Weapon sword = new Weapon("sword", "PP", 0, 10, 20, 10, 0);
    
    while(true){
      char character = input.getch();
      if(character == 'a')
        System.out.print("hello world");
      else if (character == 'e')
        break;
    }
    System.out.print("\033[H\033[2J");
    String aspodpasdfohia = input.readLine();
    System.out.print(aspodpasdfohia);
    System.exit(0);

    while(true) {
      sword.updateWeaponXP(2.4);
      displayWeapon(sword);
      String userInput = input.readLine();
      System.out.print("\033[H\033[2J");
      System.out.flush();
      while(userInput != ""){input.readLine();};
    }
  }

  public static void displayWeapon(Weapon x) {
    System.out.println(x.getAscii());
    System.out.println("\033[34m\n" + ((x.type).substring(0,1)).toUpperCase() + (x.type).substring(1) + ": " + "\033[0m" + x.name);
    System.out.println("Level: " + (x.lvl));
    System.out.println("\033[32m\nMain Stat");
    System.out.println("\033[35m" + x.getMainStatTitle() + ": \033[35m" + (x.getMainStat()));
    System.out.println("\033[31m\nSubstats");
    System.out.println("\033[35mDamage: " + "\033[0m" + (x.getDamage()) + "\033[31m" + x.getsubStatlvl(0));
    System.out.println("\033[35mCrit Damage: " + "\033[0m" + (x.getCritD()) + "%\033[31m" + x.getsubStatlvl(1));
    System.out.println("\033[35mCrit Chance: " + "\033[0m" + (x.getCritC()) + "%\033[31m" + x.getsubStatlvl(2));
    System.out.print("\033[0m");
  }

  //private static void print(Health health) {
    //System.out.print(health.render());
    //System.out.println(health.HP());
  //}
  
}
