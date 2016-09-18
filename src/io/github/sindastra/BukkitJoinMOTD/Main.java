/**
 * BukkitJoinMOTD
 * Copyright (C) 2016 Sindastra <https://github.com/sindastra>
 * All rights reserved.
 *
 * This and the above copyright notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
 * CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
 * SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 * 
 * This software is not affiliated with Bukkit.
 * 
 * @author Sindastra
 * @copyright Copyright (C) 2016 Sindastra. All rights reserved.
 */

package io.github.sindastra.BukkitJoinMOTD;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener
{
	private String motd;
	
	@Override
	public void onEnable()
	{
		getServer().getPluginManager().registerEvents(this, this);
		saveDefaultConfig();
		
		motd = getConfig().getString("motd");
		getLogger().info("Enabled! MOTD is: " + motd);
	}
	
	@Override
	public void onDisable()
	{
		getLogger().info("Disabled.");
	}
	
	@EventHandler
	public void onPlayerJoinEvent(PlayerJoinEvent event)
	{
		event.getPlayer().sendMessage(motd);
	}
}
