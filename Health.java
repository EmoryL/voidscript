public class Health {
    private int maxHP = 1500;
    private double CHP = maxHP;

    public void takeDamage(double damage) {
        if (damage < 0)
            damage = 0;
        CHP -= damage;
        if (CHP < 0)
            CHP = 0;
    }

    public void getHeal(double heal) {
        if (heal < 0)
            heal = 0;
        CHP += heal;
        if (CHP > maxHP)
            CHP = maxHP;
    }

    public String render() {
        return render(maxHP / 100);
    }

    public String render(int barLength) {
        var sb = new StringBuilder();
        int curChars = (int) Math.ceil(CHP / maxHP * barLength);

        sb.append("■".repeat(curChars));
        sb.append("□".repeat(barLength - curChars));

        return sb.toString();
    }

    public String HP() {

    return (" " + Math.round(CHP) + "/" + Math.round(maxHP) + " HP");
    }

}