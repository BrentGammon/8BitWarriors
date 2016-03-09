import greenfoot.*;
/**
 * Extensiable way for Extended Actors to be able to take damage from any source.
 * 
 * @author Mitchell Rebuck-Watson
 * @version S2 1
 */
public interface IDamageable  
{
    /**
     * Do damage to this object. Returns damage done.
     * @param attacker The actor that is the source of the attack. It may not be the actor that calls the method
     * @param damage The damage to deal
     * 
     * @return The damage that was recieved
     */
    int doDamage(Actor attacker, int damage);
}
