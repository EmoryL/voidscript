import java.util.stream.*;

public class Weapon
{
  public String type;
  public String name;
  public double lvl = 0;
  public int mStat;
  public double[] finalMainStat = {0, 0, 0};
  
  public double damageMult;
  public double critDMult;
  public double critCMult;

  public int[] subStatlvl = {0, 0, 0};
  
  public String[] mainStatTitles = {"Damage", "Crit Damage", "Crit Chance"};
  public double[] baseStats = {500, 120, 50};
  
  public Weapon(String type, String name, double lvl, double baseDamage, double baseCritD, double baseCritC, int mStat)
  {
    this.type = type;
    this.name = name;
    this.lvl = lvl;
    this.mStat = mStat;
    
    baseStats[0] = baseDamage;
    baseStats[1] = baseCritD;
    baseStats[2] = baseCritC;
  }

  public String getAscii()
  {
    String sword = 
      "         />__________________________________" + "\n" +
      "[########[]_________________________________/" + "\n" +
      "         \\>                                  ";

    switch(type){
      case "sword":
        return sword;
    }
    return "error";
  }

  public double updateWeaponXP(double amount)
  {
    lvl += amount;
    if(lvl > 100)
      lvl = 100;
    updateWeapon();
    return lvl;
  }
  
  public String getMainStatTitle()
  {
    return mainStatTitles[mStat];
  }

  public int getMainStat()
  {
    switch(mStat){
      case 0:
        return (int) finalMainStat[0];
      case 1:
        return (int) finalMainStat[1];
      case 2:
        return (int) finalMainStat[2];
    }
    return (int) finalMainStat[0];
  }

  public int getDamage()
  {
    return (int) round(baseStats[0] + damageMult);
  }

  public double getTotalDamage()
  {
    return (int) round(finalMainStat[0] + getDamage());
  }

  public int getCritD()
  {
    return (int) round(baseStats[1] + critDMult + finalMainStat[1]);
  }

  public int getCritC()
  {
    return (int) round(baseStats[2] + critCMult + finalMainStat[2]);
  }

  public String getsubStatlvl(int num)
    {
      if(subStatlvl[num] > 0)
        return " +" + subStatlvl[num];
      return "";
    }

  public String toString()
  {
    return "hello";
  }

  private void updateWeapon()
  {
    
    for(int i = 10; i < 110; i+=10){
      if((lvl >= i && IntStream.of(subStatlvl).sum() == (i/10)-1)){
        int num = (int)(Math.random() * 3);
        subStatlvl[num] += 1;
      }
    }

    damageMult = subStatlvl[0]*(baseStats[0]/10);
    critDMult = subStatlvl[1]*(baseStats[1]/10);
    critCMult = subStatlvl[2]*(baseStats[2]/10);

    for(int i = 0; i < 3; i++){
      if(mStat == i)
          finalMainStat[i] = baseStats[i] + ((baseStats[i]/100)*lvl);
    }
    
  }

  private double round(double num)
  {
    return Math.round(num * 10) / 10;
  }
  
}