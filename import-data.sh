#!/bin/bash

echo "📦 Importando datos a MongoDB (desde Docker)..."

docker run --rm -v $(pwd)/data:/data --network admin-panel_default mongo:7 \
  mongoimport --host mongo --port 27017 --db admin-panel \
  --collection products --file /data/products.json --jsonArray

docker run --rm -v $(pwd)/data:/data --network admin-panel_default mongo:7 \
  mongoimport --host mongo --port 27017 --db admin-panel \
  --collection sales --file /data/sales.json --jsonArray

echo "✅ Datos importados con éxito 🚀"