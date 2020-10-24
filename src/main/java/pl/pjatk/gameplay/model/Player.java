package pl.pjatk.gameplay.model;

public class Player {

    private int id;
    private String nickname;
    private int health;
    private int attack;
    private int mana;

    public Player(String nickname, int health, int attack, int mana) {
        this.nickname = nickname;
        this.health = health;
        this.attack = attack;
        this.mana = mana;
    }

    public Player(int id, String nickname, int health, int attack, int mana) {
        this.id = id;
        this.nickname = nickname;
        this.health = health;
        this.attack = attack;
        this.mana = mana;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }
}
