/*
 * Copyright (C) 2011 Moritz Schmale <narrow.m@gmail.com>
 *
 * Showcase is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/gpl.html>.
 */

package com.narrowtux.showcase;


public class ItemWatcher implements Runnable {
	@Override
	public void run() {
		for(ShowcaseItem item:Showcase.instance.showcasedItems){
			if(item.getItem()==null||item.getItem().isDead()){
				item.respawn();
			}
			item.updatePosition();

			/*
			if(item.getMaterial().equals(Material.TORCH)){
				//try to make it glow
				int x,y,z;
				x = item.getBlock().getX();
				y = item.getBlock().getY();
				z = item.getBlock().getZ();
				CraftWorld world = (CraftWorld)item.getBlock().getWorld();
				world.getHandle().b(EnumSkyBlock.BLOCK, x, y, z, 14);
			}*/
			//Doesn't work.
			/*CraftItem citem = (CraftItem)item.getItem();
			EntityItem eitem = (EntityItem) citem.getHandle();
			eitem.b = 0;*/ //This is a bad idea, the client won't display the items nicely then.
		}
	}
}
