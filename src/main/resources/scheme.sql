CREATE TABLE mtg_players_deck (
  id SERIAL PRIMARY KEY,
  player_name VARCHAR(50) NOT NULL,
  deck_name VARCHAR(50) NOT NULL,
  deck_format VARCHAR(50) NOT NULL,
  CONSTRAINT unique_player_deck UNIQUE (player_name, deck_name)
);

CREATE TABLE mtg_cards (
  id SERIAL PRIMARY KEY,
  card_name VARCHAR(100) NOT NULL,
  mana_cost VARCHAR(20) NOT NULL,
  converted_mana_cost INT NOT NULL,
  card_type VARCHAR(50) NOT NULL,
  power INT NOT NULL DEFAULT 0,
  toughness INT NOT NULL DEFAULT 0,
  rarity VARCHAR(20) NOT NULL,
  CONSTRAINT unique_card_name UNIQUE (card_name)
);


CREATE TABLE mtg_deck_cards (
  id SERIAL PRIMARY KEY,
  deck_id INTEGER NULL REFERENCES mtg_players_deck (id),
  card_id INTEGER NULL REFERENCES mtg_cards (id)
);


INSERT INTO mtg_players_deck (player_name, deck_name, deck_format)
VALUES ('Alice', 'Gruul Aggro', 'Standard');

INSERT INTO mtg_players_deck (player_name, deck_name, deck_format)
VALUES ('Bob', 'Esper Control', 'Modern');


INSERT INTO mtg_cards (card_name, mana_cost, converted_mana_cost, card_type, rarity)
VALUES ('Lightning Bolt', '{R}', 1, 'Instant', 'Common');

INSERT INTO mtg_cards (card_name, mana_cost, converted_mana_cost, card_type, rarity)
VALUES ('Thoughtseize', '{B}', 1, 'Sorcery', 'Rare');

INSERT INTO mtg_cards (card_name, mana_cost, converted_mana_cost, card_type, power, toughness, rarity)
VALUES ('Tarmogoyf', '{1}{G}', 2, 'Creature', 4, 5, 'Mythic Rare');

INSERT INTO mtg_cards (card_name, mana_cost, converted_mana_cost, card_type, rarity)
VALUES ('Path to Exile', '{W}', 1, 'Instant', 'Uncommon');

INSERT INTO mtg_cards (card_name, mana_cost, converted_mana_cost, card_type, rarity)
VALUES ('Cryptic Command', '{1}{U}{U}{U}', 4, 'Instant', 'Rare');

INSERT INTO mtg_cards (card_name, mana_cost, converted_mana_cost, card_type, rarity)
VALUES ('Fatal Push', '{B}', 1, 'Instant', 'Uncommon');

INSERT INTO mtg_cards (card_name, mana_cost, converted_mana_cost, card_type, rarity)
VALUES ('Force of Will', '{3}{U}', 5, 'Instant', 'Rare');

INSERT INTO mtg_cards (card_name, mana_cost, converted_mana_cost, card_type, rarity)
VALUES ('Liliana of the Veil', '{1}{B}{B}', 3, 'Planeswalker', 'Mythic Rare');

INSERT INTO mtg_cards (card_name, mana_cost, converted_mana_cost, card_type, rarity)
VALUES ('Swords to Plowshares', '{W}', 1, 'Instant', 'Uncommon');

INSERT INTO mtg_cards (card_name, mana_cost, converted_mana_cost, card_type, rarity)
VALUES ('Jace, the Mind Sculptor', '{2}{U}{U}', 4, 'Planeswalker', 'Mythic Rare');

INSERT INTO mtg_cards (card_name, mana_cost, converted_mana_cost, card_type, power, toughness, rarity)
VALUES ('Dark Confidant', '{1}{B}', 2, 'Creature', 2, 1, 'Rare');

INSERT INTO mtg_cards (card_name, mana_cost, converted_mana_cost, card_type, rarity)
VALUES ('Blood Moon', '{2}{R}', 3, 'Enchantment', 'Rare');

INSERT INTO mtg_cards (card_name, mana_cost, converted_mana_cost, card_type, power, toughness, rarity)
VALUES ('Snapcaster Mage', '{1}{U}', 2, 'Creature', 2, 1, 'Rare');

INSERT INTO mtg_cards (card_name, mana_cost, converted_mana_cost, card_type, rarity)
VALUES ('Aether Vial', '{1}', 1, 'Artifact', 'Rare');

INSERT INTO mtg_cards (card_name, mana_cost, converted_mana_cost, card_type, rarity)
VALUES ('Karn Liberated', '{7}', 7, 'Planeswalker', 'Mythic Rare');

INSERT INTO mtg_cards (card_name, mana_cost, converted_mana_cost, card_type, rarity)
VALUES ('Inquisition of Kozilek', '{B}', 1, 'Sorcery', 'Uncommon');

INSERT INTO mtg_cards (card_name, mana_cost, converted_mana_cost, card_type, power, toughness, rarity)
VALUES ('Goblin Guide', '{R}', 1, 'Creature', 2, 2, 'Rare');

INSERT INTO mtg_cards (card_name, mana_cost, converted_mana_cost, card_type, rarity)
VALUES ('Eldrazi Temple', '{T}', 0, 'Land', 'Rare');

INSERT INTO mtg_cards (card_name, mana_cost, converted_mana_cost, card_type, rarity)
VALUES ('Ensnaring Bridge', '{3}', 3, 'Artifact', 'Rare');

INSERT INTO mtg_cards (card_name, mana_cost, converted_mana_cost, card_type, power, toughness, rarity)
VALUES ('Snapcaster Mage', '{1}{U}', 2, 'Creature', 2, 1, 'Mythic Rare');

INSERT INTO mtg_cards (card_name, mana_cost, converted_mana_cost, card_type, rarity)
VALUES ('Brainstorm', '{U}', 1, 'Instant', 'Common');

INSERT INTO mtg_cards (card_name, mana_cost, converted_mana_cost, card_type, power, toughness, rarity)
VALUES ('Delver of Secrets', '{U}', 1, 'Creature', 1, 1, 'Uncommon');

INSERT INTO mtg_cards (card_name, mana_cost, converted_mana_cost, card_type, power, toughness, rarity)
VALUES ('Deaths Shadow', '{B}{B}', 1, 'Creature', 13, 13, 'Rare');

INSERT INTO mtg_cards (card_name, mana_cost, converted_mana_cost, card_type, power, toughness, rarity)
VALUES ('Tasigur, the Golden Fang', '{1}{B}{G}', 4, 'Creature', 4, 5, 'Rare');

INSERT INTO mtg_cards (card_name, mana_cost, converted_mana_cost, card_type, power, toughness, rarity)
VALUES ('Deathrite Shaman', '{B/G}', 1, 'Creature', 1, 2, 'Rare');

INSERT INTO mtg_cards (card_name, mana_cost, converted_mana_cost, card_type, rarity)
VALUES ('Sneak Attack', '{2}{R}', 3, 'Enchantment', 'Rare');

INSERT INTO mtg_cards (card_name, mana_cost, converted_mana_cost, card_type, rarity)
VALUES ('Blood Moon', '{2}{R}', 3, 'Enchantment', 'Rare');

INSERT INTO mtg_cards (card_name, mana_cost, converted_mana_cost, card_type, power, toughness, rarity)
VALUES ('Griselbrand', '{4}{B}{B}', 8, 'Creature', 7, 7, 'Mythic Rare');

INSERT INTO mtg_cards (card_name, mana_cost, converted_mana_cost, card_type, power, toughness, rarity)
VALUES ('Emrakul, the Aeons Torn', '{15}', 15, 'Creature', 15, 15, 'Mythic Rare');

INSERT INTO mtg_cards (card_name, mana_cost, converted_mana_cost, card_type, rarity)
VALUES ('Ancestral Recall', '{U}', 1, 'Instant', 'Rare');

INSERT INTO mtg_cards (card_name, mana_cost, converted_mana_cost, card_type, rarity)
VALUES ('Black Lotus', '{0}', 0, 'Artifact', 'Rare');

INSERT INTO mtg_cards (card_name, mana_cost, converted_mana_cost, card_type, rarity)
VALUES ('Mox Sapphire', '{0}', 0, 'Artifact', 'Rare');

INSERT INTO mtg_cards (card_name, mana_cost, converted_mana_cost, card_type, power, toughness, rarity)
VALUES ('Urza, Lord High Artificer', '{2}{U}', 4, 'Legendary Creature', 1, 4, 'Mythic Rare');

INSERT INTO mtg_cards (card_name, mana_cost, converted_mana_cost, card_type, power, toughness, rarity)
VALUES ('Oko, Thief of Crowns', '{1}{G}{U}', 3, 'Planeswalker', 'Mythic Rare');

INSERT INTO mtg_cards (card_name, mana_cost, converted_mana_cost, card_type, power, toughness, rarity)
VALUES ('Uro, Titan of Nature''s Wrath', '{1}{G}{U}', 3, 'Creature', 6, 6, 'Mythic Rare');

INSERT INTO mtg_cards (card_name, mana_cost, converted_mana_cost, card_type, power, toughness, rarity)
VALUES ('Demonic Tutor', '{1}{B}', 2, 'Sorcery', 'Uncommon');

INSERT INTO mtg_cards (card_name, mana_cost, converted_mana_cost, card_type, power, toughness, rarity)
VALUES ('Necropotence', '{B}{B}{B}', 3, 'Enchantment', 'Rare');

INSERT INTO mtg_cards (card_name, mana_cost, converted_mana_cost, card_type, power, toughness, rarity)
VALUES ('Time Walk', '{1}{U}', 2, 'Sorcery', 'Rare');

INSERT INTO mtg_cards (card_name, mana_cost, converted_mana_cost, card_type, power, toughness, rarity)
VALUES ('Time Vault', '{2}', 2, 'Artifact', 'Rare');


INSERT INTO mtg_deck_cards (deck_id)
VALUES (1);

INSERT INTO mtg_deck_cards (deck_id)
VALUES (2);


SELECT pd.player_name, pd.deck_name, c.card_name, c.mana_cost, c.converted_mana_cost, c.card_type, c.power, c.toughness, c.rarity
FROM mtg_players_deck pd
INNER JOIN mtg_deck_cards dc ON pd.id = dc.deck_id
INNER JOIN mtg_cards c ON dc.card_id = c.id;