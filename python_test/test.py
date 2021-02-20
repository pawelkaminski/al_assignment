"""
Tests if multi socket connection on one ip to coinbase if fine: documentation was not clear
"""
import asyncio
import json

import websockets


async def sock(symbol_id, number):
    await asyncio.sleep(number)
    uri = "wss://ws-feed.pro.coinbase.com/"

    print(f"Task {symbol_id}: wait({number})")
    async with websockets.connect(uri) as websocket:

        print(f"Task {symbol_id}: wait({number})")

        sub = {
            "type": "subscribe",
            "product_ids": [
                symbol_id,
            ],
            "channels": [
                "full",
            ]
        }

        await websocket.send(json.dumps(sub))
        x = 1
        with open("res.json", "w") as file:
            while x < 20000:
                x += 1
                if (x % 1000) == 0:
                    print(f"Task {symbol_id}-{number}: works {x}")
                greeting = await websocket.recv()
    print(f"Task {symbol_id}: ENDS")

async def main():
    # Schedule calls *concurrently*:
    await asyncio.gather(
        sock("ETH-USD", 2),
        sock("ETH-BTC", 4),
        sock("LINK-USD", 6),
        sock("UNI-USD", 8),
        sock("XTZ-USD", 10),
    )

asyncio.run(main())