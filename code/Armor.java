public class Armor
{
  private String Name;
  private double lvl;

  private double baseDefense;
  private double baseDamage;
  private double baseCritD;
  private double baseCritC;

  private double defenceMult;
  private double damageMult;
  private double critDMult;
  private double critCMult;

  private String[] statTitles = {"defence", "damage", "critD", "critC"};
  
  public Armor(String name, double lvl, double baseDefense, double baseDamage, double baseCritD, double baseCritC, double subStat1, double subStat2, double subStat3, double subStat4, double subStatlvl1, double subStatlvl2, double subStatlvl3, double subStatlvl4)
  {
    this.Name = name;
    this.lvl = lvl;
    this.baseDefense = baseDefense;
    this.baseDamage = baseDamage;
    this.critDMult = critDMult;
    this.critCMult = critCMult;
    defenceMult = subStat1;
    damageMult = subStat2;
    critDMult = subStat3;
    critCMult = subStat4;
  }

}