package com.alessiodp.parties.bungeecord.events;

import com.alessiodp.core.bungeecord.events.BungeeEventDispatcher;
import com.alessiodp.parties.api.enums.JoinCause;
import com.alessiodp.parties.api.enums.LeaveCause;
import com.alessiodp.parties.api.events.bungee.party.BungeePartiesPartyGetExperienceEvent;
import com.alessiodp.parties.api.events.bungee.party.BungeePartiesPartyLevelUpEvent;
import com.alessiodp.parties.api.events.bungee.party.BungeePartiesPartyPostCreateEvent;
import com.alessiodp.parties.api.events.bungee.party.BungeePartiesPartyPostDeleteEvent;
import com.alessiodp.parties.api.events.bungee.party.BungeePartiesPartyPostRenameEvent;
import com.alessiodp.parties.api.events.bungee.party.BungeePartiesPartyPreCreateEvent;
import com.alessiodp.parties.api.events.bungee.party.BungeePartiesPartyPreDeleteEvent;
import com.alessiodp.parties.api.events.bungee.party.BungeePartiesPartyPreRenameEvent;
import com.alessiodp.parties.api.events.bungee.player.BungeePartiesPlayerPostChatEvent;
import com.alessiodp.parties.api.events.bungee.player.BungeePartiesPlayerPostInviteEvent;
import com.alessiodp.parties.api.events.bungee.player.BungeePartiesPlayerPostJoinEvent;
import com.alessiodp.parties.api.events.bungee.player.BungeePartiesPlayerPostLeaveEvent;
import com.alessiodp.parties.api.events.bungee.player.BungeePartiesPlayerPreChatEvent;
import com.alessiodp.parties.api.events.bungee.player.BungeePartiesPlayerPreInviteEvent;
import com.alessiodp.parties.api.events.bungee.player.BungeePartiesPlayerPreJoinEvent;
import com.alessiodp.parties.api.events.bungee.player.BungeePartiesPlayerPreLeaveEvent;
import com.alessiodp.parties.api.events.bungee.unique.BungeePartiesPartyFollowEvent;
import com.alessiodp.parties.api.events.common.party.IPartyGetExperienceEvent;
import com.alessiodp.parties.api.events.common.party.IPartyLevelUpEvent;
import com.alessiodp.parties.api.events.common.party.IPartyPostCreateEvent;
import com.alessiodp.parties.api.events.common.party.IPartyPostDeleteEvent;
import com.alessiodp.parties.api.events.common.party.IPartyPostRenameEvent;
import com.alessiodp.parties.api.events.common.party.IPartyPreCreateEvent;
import com.alessiodp.parties.api.events.common.party.IPartyPreDeleteEvent;
import com.alessiodp.parties.api.events.common.party.IPartyPreRenameEvent;
import com.alessiodp.parties.api.events.common.player.IPlayerPostChatEvent;
import com.alessiodp.parties.api.events.common.player.IPlayerPostInviteEvent;
import com.alessiodp.parties.api.events.common.player.IPlayerPostJoinEvent;
import com.alessiodp.parties.api.events.common.player.IPlayerPostLeaveEvent;
import com.alessiodp.parties.api.events.common.player.IPlayerPreChatEvent;
import com.alessiodp.parties.api.events.common.player.IPlayerPreInviteEvent;
import com.alessiodp.parties.api.events.common.player.IPlayerPreJoinEvent;
import com.alessiodp.parties.api.events.common.player.IPlayerPreLeaveEvent;
import com.alessiodp.parties.common.PartiesPlugin;
import com.alessiodp.parties.common.events.EventManager;
import com.alessiodp.parties.api.enums.DeleteCause;
import com.alessiodp.parties.api.interfaces.Party;
import com.alessiodp.parties.api.interfaces.PartyPlayer;

public class BungeeEventManager extends EventManager {
	
	public BungeeEventManager(PartiesPlugin plugin) {
		super(plugin, new BungeeEventDispatcher(plugin));
	}
	
	@Override
	public IPartyPostCreateEvent preparePartyPostCreateEvent(PartyPlayer player, Party party) {
		return new BungeePartiesPartyPostCreateEvent(player, party);
	}
	
	@Override
	public IPartyPostDeleteEvent preparePartyPostDeleteEvent(Party party, DeleteCause cause, PartyPlayer kickedPlayer, PartyPlayer commandSender) {
		return new BungeePartiesPartyPostDeleteEvent(party, cause, kickedPlayer, commandSender);
	}
	
	@Override
	public IPartyPreCreateEvent preparePartyPreCreateEvent(PartyPlayer player, String name, boolean fixed) {
		return new BungeePartiesPartyPreCreateEvent(player, name, fixed);
	}
	
	@Override
	public IPartyPreDeleteEvent preparePartyPreDeleteEvent(Party party, DeleteCause cause, PartyPlayer kickedPlayer, PartyPlayer commandSender) {
		return new BungeePartiesPartyPreDeleteEvent(party, cause, kickedPlayer, commandSender);
	}
	
	@Override
	public IPartyPreRenameEvent preparePartyPreRenameEvent(Party party, String oldName, String newName, PartyPlayer player, boolean isAdmin) {
		return new BungeePartiesPartyPreRenameEvent(party, oldName, newName, player, isAdmin);
	}
	
	@Override
	public IPartyPostRenameEvent preparePartyPostRenameEvent(Party party, String oldName, String newName, PartyPlayer player, boolean isAdmin) {
		return new BungeePartiesPartyPostRenameEvent(party, oldName, newName, player, isAdmin);
	}
	
	@Override
	public IPartyGetExperienceEvent preparePartyGetExperienceEvent(Party party, double experience, PartyPlayer killer) {
		return new BungeePartiesPartyGetExperienceEvent(party, experience, killer);
	}
	
	@Override
	public IPlayerPreChatEvent preparePlayerPreChatEvent(PartyPlayer player, Party party, String message) {
		return new BungeePartiesPlayerPreChatEvent(player, party, message);
	}
	
	@Override
	public IPlayerPostChatEvent preparePlayerPostChatEvent(PartyPlayer player, Party party, String message) {
		return new BungeePartiesPlayerPostChatEvent(player, party, message);
	}
	
	@Override
	public IPlayerPreJoinEvent preparePlayerPreJoinEvent(PartyPlayer player, Party party, JoinCause cause, PartyPlayer inviter) {
		return new BungeePartiesPlayerPreJoinEvent(player, party, cause, inviter);
	}
	
	@Override
	public IPlayerPostJoinEvent preparePlayerPostJoinEvent(PartyPlayer player, Party party, JoinCause cause, PartyPlayer inviter) {
		return new BungeePartiesPlayerPostJoinEvent(player, party, cause, inviter);
	}
	
	@Override
	public IPlayerPreLeaveEvent preparePlayerPreLeaveEvent(PartyPlayer player, Party party, LeaveCause cause, PartyPlayer kicker) {
		return new BungeePartiesPlayerPreLeaveEvent(player, party, cause, kicker);
	}
	
	@Override
	public IPlayerPostLeaveEvent preparePlayerPostLeaveEvent(PartyPlayer player, Party party, LeaveCause cause, PartyPlayer kicker) {
		return new BungeePartiesPlayerPostLeaveEvent(player, party, cause, kicker);
	}
	
	@Override
	public IPlayerPreInviteEvent preparePlayerPreInviteEvent(PartyPlayer invitedPlayer, PartyPlayer inviter, Party party) {
		return new BungeePartiesPlayerPreInviteEvent(invitedPlayer, inviter, party);
	}
	
	@Override
	public IPlayerPostInviteEvent preparePlayerPostInviteEvent(PartyPlayer invitedPlayer, PartyPlayer inviter, Party party) {
		return new BungeePartiesPlayerPostInviteEvent(invitedPlayer, inviter, party);
	}
	
	@Override
	public IPartyLevelUpEvent prepareLevelUpEvent(Party party, int newLevel) {
		return new BungeePartiesPartyLevelUpEvent(party, newLevel);
	}
	
	public BungeePartiesPartyFollowEvent preparePartyFollowEvent(Party party, String server) {
		return new BungeePartiesPartyFollowEvent(party, server);
	}
}
