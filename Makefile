export HOST_UID := $(shell id -u)
export HOST_GID := $(shell id -g)

DC       = docker compose
DATA_DIR = .docker/mariadb

$(DATA_DIR):
	mkdir -p $(DATA_DIR)

build: $(DATA_DIR)
	$(DC) pull
	$(DC) build

up: $(DATA_DIR)
	$(DC) up -d --wait

start: build up

down:
	$(DC) down

stop:
	$(DC) stop

restart: down up

ps:
	$(DC) ps

logs:
	$(DC) logs -f

db:
	$(DC) exec mariadb mariadb -uroot -proot db_domedespuys

reset:
	$(DC) down -v
	rm -rf $(DATA_DIR)
	$(MAKE) up
