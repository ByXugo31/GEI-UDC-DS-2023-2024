package e2;

import e2.Objects.Attack.FireBallSpell;
import e2.Objects.Defense.Armor;
import e2.Objects.Mixed.Sword;
import e2.Objects.Mixed.Wand;
import e2.Personajes.Personaje;
import e2.Personajes.Warrior;
import e2.Personajes.Wizard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class Test2 {

    private static Personaje wizard;
    private static Personaje warrior;

    @BeforeEach
    public void setup(){
        wizard = new Wizard("wizard");
        warrior = new Warrior("warrior");
    }

    @Test
    public void testPersonaje() {
        // Añadir objetos de ataque y defensa a los personajes
        wizard.addObjetoAtaque(new Sword());
        wizard.addObjetoDefensa(new Armor());
        wizard.addObjetoDefensa(new Armor());

        warrior.addObjetoAtaque(new Sword());
        warrior.addObjetoDefensa(new Armor());

        // Verificar que los personajes devuelven la defensa correcta
        assertEquals(4, warrior.getDefensa());
        assertEquals(8, wizard.getDefensa());

        // Verificar que los personajes devuelven el daño correcto
        assertEquals(6, warrior.getDano());
        assertEquals(6, wizard.getDano());
    }

    @Test
    public void limiteObjetos() {
        // Añadir objetos de ataque y defensa hasta alcanzar el límite
        warrior.addObjetoAtaque(new Sword());
        warrior.addObjetoAtaque(new Wand());
        warrior.addObjetoAtaque(new FireBallSpell());
        warrior.addObjetoAtaque(new FireBallSpell());
        warrior.addObjetoAtaque(new FireBallSpell());


        assertThrows(IllegalArgumentException.class, () -> warrior.addObjetoAtaque(new Sword()));

        // Añadir objetos de defensa hasta alcanzar el límite
        warrior.addObjetoDefensa(new Armor());
        warrior.addObjetoDefensa(new Armor());
        warrior.addObjetoDefensa(new Armor());
        warrior.addObjetoDefensa(new Armor());
        warrior.addObjetoDefensa(new Armor());

        // Intentar añadir más objetos de defensa debe lanzar una excepción
        assertThrows(IllegalArgumentException.class, () -> warrior.addObjetoDefensa(new Armor()));
    }

    @Test
    public void testObjetosAtaque() {
        // Crear 2 objeto de ataque
        FireBallSpell fireBall = new FireBallSpell();
        Wand wand = new Wand();

        // Verificar que los objeto de ataque devuelven los valores correctos
        assertEquals("fball", fireBall.getCode());
        assertEquals(3, fireBall.getMinMana());
        assertEquals(5, fireBall.getUsos());
        assertEquals("wand", wand.getCode());
        assertEquals(4, wand.getMinMana());
        assertEquals(7, wand.getUsos());

        // Verificar que cuando no quedan usos no hacen daño
        fireBall.setUsos(0);
        assertEquals(0, fireBall.getUsos());
        assertEquals(0, fireBall.getDano());

        // Verificar que el daño disminuye en uno cuando los usos son 1
        fireBall.setUsos(2);
        assertEquals(9,fireBall.getDano());
        assertEquals(1, fireBall.getUsos());
        assertEquals(8,fireBall.getDano());
        assertEquals(0, fireBall.getUsos());

        //Verificar que el daño se multiplica x2 en el primer uso
        assertEquals(16, wand.getDano());

        //Verificar que despues del primer uso ya hacer un daño normal
        assertEquals(6, wand.getUsos());
        assertEquals(8, wand.getDano());
    }

    @Test
    public void testObjetosDefensa() {
        // Crear un objeto de defensa
        Armor armadura1 = new Armor();

        // Verificar que el objeto de defensa devuelve los valores correctos
        assertEquals("armor", armadura1.getCode());
        assertEquals(4, armadura1.getMinFuerza());
        assertEquals(4, armadura1.getDefensa());
    }

    @Test
    public void testObjetosMixed(){
        //Crear un objeto mixed
        Sword s1=new Sword();
        Wand wand = new Wand();

        //Obtencion atributos de objetos mixtos
        assertEquals("sword", s1.getCode());
        assertEquals(2, s1.getMinFuerza());
        assertEquals(2, s1.getDefensa());
        assertEquals("wand", wand.getCode());
        assertEquals(1, wand.getMinFuerza());
        assertEquals(1, wand.getDefensa());
    }

    @Test
    public void testGame1() {
        // Añadir objetos de ataque y defensa a los personajes
        wizard.addObjetoAtaque(new FireBallSpell());
        warrior.addObjetoDefensa(new Armor());

        // Crear un juego con un límite de turnos
        Game game = new Game(5, wizard, warrior);

        // Verificar que el método game1 calcula correctamente el daño
        int damage = game.game1(wizard,warrior);
        assertEquals(wizard.getDano() - warrior.getDefensa(), damage);
    }

    @Test
    public void testGame2GanaPersonaje1() {

        Armor a1= new Armor();
        Armor a2= new Armor();
        Sword s1= new Sword();
        Sword s2= new Sword();

        warrior.addObjetoDefensa(a1);
        wizard.addObjetoDefensa(a2);
        warrior.addObjetoAtaque(s1);
        wizard.addObjetoAtaque(s2);

        Game game = new Game(20, warrior, wizard);

        // Verificación del método game2
        assertEquals(warrior, game.game2()); // Debería ganar warrior
        assertEquals("warrior", game.game2().getNombre());
    }

    @Test
    public void testGame2GanaPersonaje2() {
        Sword s1= new Sword();
        wizard.addObjetoAtaque(s1);
        Game game = new Game(3, warrior, wizard);

        // Verificación del método game2
        assertEquals(wizard, game.game2());
        assertEquals("wizard", game.game2().getNombre());
    }

    @Test
    public void testGame2Draw() {
        // Configuración de personajes y juego
        Game game = new Game(3, wizard, warrior);
        Armor armor = new Armor();
        Sword sword = new Sword();
        warrior.addObjetoDefensa(armor);
        warrior.addObjetoDefensa(armor);
        warrior.addObjetoDefensa(armor);
        warrior.addObjetoDefensa(armor);
        warrior.addObjetoDefensa(armor);
        wizard.addObjetoAtaque(sword);

        // Verificación del método game2
        Personaje resultado = game.game2();
        assertNull(resultado); // Debería ser un empate
    }
}