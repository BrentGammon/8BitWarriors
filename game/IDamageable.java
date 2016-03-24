package game;

import greenfoot.*;
/**
 * Write a description of class IDamageable here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface IDamageable  
{
    /**
     * do damage to this object. Returns damage done.
     */
    int doDamage(Actor attacker, int damage);
}
