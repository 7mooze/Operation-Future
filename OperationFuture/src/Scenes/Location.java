package Scenes;

import java.util.ArrayList;

import Characters.Alien;
import Characters.Character;
import Objects.Object;


public abstract class Location{
	
	public String name;
	public String map;
	public String grid;
	
	public ArrayList<Object> objects;
	public ArrayList<Character> characters;
	public ArrayList<Alien> aliens;
	
}

