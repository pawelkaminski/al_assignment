import json

import asyncio
import websockets


async def hello():
    uri = "wss://ws-feed.pro.coinbase.com/"
    async with websockets.connect(uri) as websocket:

        print('before send')

        sub = {
            "type": "subscribe",
            "product_ids": [
                #"USD-BTC",
                "ETH-USD"
            ],
            "channels": [
                "full",
            ]
        }

        await websocket.send(json.dumps(sub))
        x = 1

        with open("res.json", "w") as file:
            while x < 2000:
                x += 1
                greeting = await websocket.recv()
                print(greeting)
                file.write(greeting)

                file.write("\n")

asyncio.get_event_loop().run_until_complete(hello())