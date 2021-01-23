package pl.pjatk.gameplay.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickname;
    private int health;
    private int attack;
    private int mana;

    @OneToMany(mappedBy = "player",
            cascade = CascadeType.ALL)
    private List<Messages> messagesList = new ArrayList<>();

    public Player(String nickname, int health, int attack, int mana) {
        this.nickname = nickname;
        this.health = health;
        this.attack = attack;
        this.mana = mana;
    }

    public Player(Long id, String nickname, int health, int attack, int mana, List<Messages> messagesList) {
        this.id = id;
        this.nickname = nickname;
        this.health = health;
        this.attack = attack;
        this.mana = mana;
        this.messagesList = messagesList;
    }

    public Player(String nickname, int health, int attack, int mana, List<Messages> messagesList) {
        this.nickname = nickname;
        this.health = health;
        this.attack = attack;
        this.mana = mana;
        this.messagesList = messagesList;
    }

    public Player() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public List<Messages> getMessagesList() {
        return messagesList;
    }

    public void setMessagesList(List<Messages> messagesList) {
        this.messagesList = messagesList;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", health=" + health +
                ", attack=" + attack +
                ", mana=" + mana +
                ", messagesList=" + messagesList +
                '}';
    }
}
