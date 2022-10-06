package com.example.spotifyclone555.data

import com.example.spotifyclone555.model.Album
import com.example.spotifyclone555.model.Song

class DataC {
    companion object{

        fun getAlbums(): List<Album>{
            return arrayListOf(album0,album1,album2,album3,album4,album5,album6,album7,album8,album9,album10,album11,album12)
        }

        val song1 = Song(0,"Lullabies To Paralyze","Queens of the Stone Age",
            "This Lullaby","https://github.com/utkuoruc/spotify_repo/raw/master/music/this-lullaby.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/lullabies-to-paralyze.jpg")
        val song2 = Song(1,"Lullabies To Paralyze","Queens of the Stone Age",
            "Medication","https://github.com/utkuoruc/spotify_repo/raw/master/music/medication.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/lullabies-to-paralyze.jpg")
        val song3 = Song(2,"Lullabies To Paralyze","Queens of the Stone Age",
            "Everybody Knows That You're Insane","https://github.com/utkuoruc/spotify_repo/raw/master/music/everybody-knows-that-youre-insane.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/lullabies-to-paralyze.jpg")
        val song4 = Song(3,"Lullabies To Paralyze","Queens of the Stone Age",
            "Tangled Up In Plaid","https://github.com/utkuoruc/spotify_repo/raw/master/music/tangled-up-in-plaid.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/lullabies-to-paralyze.jpg")
        val song5 = Song(4,"Lullabies To Paralyze","Queens of the Stone Age",
            "Burn The Witch","https://github.com/utkuoruc/spotify_repo/raw/master/music/burn-the-witch.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/lullabies-to-paralyze.jpg")
        val song6 = Song(5,"Lullabies To Paralyze","Queens of the Stone Age",
            "In My Head","https://github.com/utkuoruc/spotify_repo/raw/master/music/in-my-head.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/lullabies-to-paralyze.jpg")
        val song7 = Song(6,"Lullabies To Paralyze","Queens of the Stone Age",
            "Little Sister","https://github.com/utkuoruc/spotify_repo/raw/master/music/little-sister.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/lullabies-to-paralyze.jpg")
        val song8 = Song(7,"Lullabies To Paralyze","Queens of the Stone Age",
            "I Never Came","https://github.com/utkuoruc/spotify_repo/raw/master/music/i-never-came.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/lullabies-to-paralyze.jpg")
        val song9 = Song(8,"Lullabies To Paralyze","Queens of the Stone Age",
            "Someone's In The Wolf","https://github.com/utkuoruc/spotify_repo/raw/master/music/someones-in-the-wolf.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/lullabies-to-paralyze.jpg")
        val song0 = Song(9,"Lullabies To Paralyze","Queens of the Stone Age",
            "The Blood Is Love","https://github.com/utkuoruc/spotify_repo/raw/master/music/the-blood-is-love.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/lullabies-to-paralyze.jpg")

        val song_0 = Song(0,"Opp Pack Smoker","Lil Droptop Golf Cart",
            "Opp Pack Smoker","https://github.com/utkuoruc/spotify_repo/raw/master/music/opp-pack-smoker.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/opp-pack-smoker.jpeg")
        val song_1 = Song(1,"Opp Pack Smoker","Lil Droptop Golf Cart",
            "Opp Pack Smoker 2","https://github.com/utkuoruc/spotify_repo/raw/master/music/opp-pack-smoker-2.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/opp-pack-smoker-2.jpeg")
        val song_2 = Song(2,"Opp Pack Smoker","Lil Droptop Golf Cart",
            "Opp Pack Smoker 3","https://github.com/utkuoruc/spotify_repo/raw/master/music/opp-pack-smoker-3.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/opp-pack-smoker-3.jpeg")
        val song_3 = Song(3,"Opp Pack Smoker","Lil Droptop Golf Cart",
            "Opp Pack Smoker 4","https://github.com/utkuoruc/spotify_repo/raw/master/music/opp-pack-smoker-4.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/opp-pack-smoker-4.jpeg")
        val song_4 = Song(4,"Opp Pack Smoker","Lil Droptop Golf Cart",
            "Opp Pack Smoker 5","https://github.com/utkuoruc/spotify_repo/raw/master/music/opp-pack-smoker-5.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/opp-pack-smoker-5.jpeg")
        val song_5 = Song(5,"Opp Pack Smoker","Lil Droptop Golf Cart",
            "Opp Pack Smoker 6","https://github.com/utkuoruc/spotify_repo/raw/master/music/opp-pack-smoker-6.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/opp-pack-smoker-6.jpeg")
        val song_6 = Song(6,"Opp Pack Smoker","Lil Droptop Golf Cart",
            "Opp Pack Smoker 7","https://github.com/utkuoruc/spotify_repo/raw/master/music/opp-pack-smoker-7.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/opp-pack-smoker-7.jpeg")
        val song_7 = Song(7,"Opp Pack Smoker","Lil Droptop Golf Cart",
            "Opp Pack Smoker 8","https://github.com/utkuoruc/spotify_repo/raw/master/music/opp-pack-smoker-8.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/opp-pack-smoker-8.jpeg")

        val toxicity_0 = Song(0,"Toxicity","System Of A Down",
            "Prison Song","https://github.com/utkuoruc/spotify_repo/raw/master/music/prison-song.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/toxicity.jpeg")
        val toxicity_1 = Song(1,"Toxicity","System Of A Down",
            "X","https://github.com/utkuoruc/spotify_repo/raw/master/music/x.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/toxicity.jpeg")
        val toxicity_2 = Song(2,"Toxicity","System Of A Down",
            "Chop Suey!","https://github.com/utkuoruc/spotify_repo/raw/master/music/chop-suey.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/toxicity.jpeg")
        val toxicity_3 = Song(3,"Toxicity","System Of A Down",
            "Forest","https://github.com/utkuoruc/spotify_repo/raw/master/music/forest.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/toxicity.jpeg")
        val toxicity_4 = Song(4,"Toxicity","System Of A Down",
            "ATWA","https://github.com/utkuoruc/spotify_repo/raw/master/music/atwa.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/toxicity.jpeg")
        val toxicity_5 = Song(5,"Toxicity","System Of A Down",
            "Toxicity","https://github.com/utkuoruc/spotify_repo/raw/master/music/toxicity.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/toxicity.jpeg")
        val toxicity_6 = Song(6,"Toxicity","System Of A Down",
            "Psycho","https://github.com/utkuoruc/spotify_repo/raw/master/music/psycho.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/toxicity.jpeg")
        val toxicity_7 = Song(7,"Toxicity","System Of A Down",
            "Aerials","https://github.com/utkuoruc/spotify_repo/raw/master/music/aerials.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/toxicity.jpeg")

        val sftd_0 = Song(0,"Songs For The Deaf","Queens of the Stone Age",
            "You Think I Ain't Worth A Dollar, But I Feel Like A Millionaire","https://github.com/utkuoruc/spotify_repo/raw/master/music/you-think-i-aint-worth-a-dollar-but-i-feel-like-a-millionaire.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/songs-for-the-deaf.jpeg")
        val sftd_1 = Song(1,"Songs For The Deaf","Queens of the Stone Age",
            "No One Knows","https://github.com/utkuoruc/spotify_repo/raw/master/music/no-one-knows.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/songs-for-the-deaf.jpeg")
        val sftd_2 = Song(2,"Songs For The Deaf","Queens of the Stone Age",
            "First It Giveth","https://github.com/utkuoruc/spotify_repo/raw/master/music/first-it-giveth.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/songs-for-the-deaf.jpeg")
        val sftd_3 = Song(3,"Songs For The Deaf","Queens of the Stone Age",
            "Song For The Dead","https://github.com/utkuoruc/spotify_repo/raw/master/music/song-for-the-dead.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/songs-for-the-deaf.jpeg")
        val sftd_4 = Song(4,"Songs For The Deaf","Queens of the Stone Age",
            "The Sky Is Fallin'","https://github.com/utkuoruc/spotify_repo/raw/master/music/the-sky-is-fallin.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/songs-for-the-deaf.jpeg")

        val box_0 = Song(0,"Box Chevy","Yelawolf","Box Chevy",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/box-chevy.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/box-chevy.jpeg")
        val box_1 = Song(1,"Box Chevy","Yelawolf","Box Chevy V",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/box-chevy-5.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/love-story.jpeg")
        val box_2 = Song(2,"Box Chevy","Yelawolf","Box Chevy 6",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/box-chevy-6.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/box-chevy-6.jpeg")
        val box_3 = Song(3,"Box Chevy","Yelawolf","Box Chevy 7",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/box-chevy-7.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/box-chevy-7.jpeg")

        val a0_song0 = Song(0,"Dressed Up As Life","Sick Puppies","My World",
        "https://github.com/utkuoruc/spotify_repo/raw/master/music/my-world.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/dressed-up-as-life.jpg")
        val a0_song1 = Song(1,"Dressed Up As Life","Sick Puppies","Pitiful",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/pitiful.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/dressed-up-as-life.jpg")
        val a0_song2 = Song(2,"Dressed Up As Life","Sick Puppies","Cancer",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/cancer.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/dressed-up-as-life.jpg")
        val a0_song3 = Song(3,"Dressed Up As Life","Sick Puppies","All The Same",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/all-the-same%2C.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/dressed-up-as-life.jpg")
        val a0_song4 = Song(4,"Dressed Up As Life","Sick Puppies","Too Many Words",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/too-many-words.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/dressed-up-as-life.jpg")

        val a1_song0 = Song(0,"Vol.3: The Subliminal Verses","Slipknot","Prelude 3.0",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/prelude-30.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/vol-3-the-subliminal-verses.jpeg")
        val a1_song1 = Song(1,"Vol.3: The Subliminal Verses","Slipknot","The Blister Exists",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/the-blister-exists.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/vol-3-the-subliminal-verses.jpeg")
        val a1_song2 = Song(2,"Vol.3: The Subliminal Verses","Slipknot","Duality",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/duality.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/vol-3-the-subliminal-verses.jpeg")
        val a1_song3 = Song(3,"Vol.3: The Subliminal Verses","Slipknot","Opium Of The People",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/opium-of-the-people.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/vol-3-the-subliminal-verses.jpeg")
        val a1_song4 = Song(4,"Vol.3: The Subliminal Verses","Slipknot","Circle",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/circle.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/vol-3-the-subliminal-verses.jpeg")
        val a1_song5 = Song(5,"Vol.3: The Subliminal Verses","Slipknot","Vermilion",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/vermilion.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/vol-3-the-subliminal-verses.jpeg")
        val a1_song6 = Song(6,"Vol.3: The Subliminal Verses","Slipknot","Pulse Of The Maggots",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/pulse-of-the-maggots.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/vol-3-the-subliminal-verses.jpeg")
        val a1_song7 = Song(7,"Vol.3: The Subliminal Verses","Slipknot","Before I Forget",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/before-i-forget.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/vol-3-the-subliminal-verses.jpeg")
        val a1_song8 = Song(8,"Vol.3: The Subliminal Verses","Slipknot","The Virus Of Life",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/the-virus-of-life.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/vol-3-the-subliminal-verses.jpeg")

        val a2_song0 = Song(0,"Rated R","Queens of the Stone Age","Feel Good Hit Of The Summer",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/feel-good-hit-of-the-summer.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/rated-r.jpeg")
        val a2_song1 = Song(1,"Rated R","Queens of the Stone Age","The Lost Art Of Keeping A Secret",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/the-lost-art-of-keeping-a-secret.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/rated-r.jpeg")
        val a2_song2 = Song(2,"Rated R","Queens of the Stone Age","Auto Pilot",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/auto-pilot.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/rated-r.jpeg")
        val a2_song3 = Song(3,"Rated R","Queens of the Stone Age","Better Living Through Chemistry",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/better-living-through-chemistry.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/rated-r.jpeg")
        val a2_song4 = Song(4,"Rated R","Queens of the Stone Age","Monsters in the Parasol",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/monsters-in-the-parasol.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/rated-r.jpeg")
        val a2_song5 = Song(5,"Rated R","Queens of the Stone Age","In the Fade",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/in-the-fadefeel-good-hit-of-the-summer-reprise.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/rated-r.jpeg")
        val a2_song6 = Song(6,"Rated R","Queens of the Stone Age","I Think I Lost My Headache",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/i-think-i-lost-my-headache.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/rated-r.jpeg")

        val a3_song0 = Song(0,"Post","Björk","Hyper Ballad",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/hyper-ballad.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/post.jpeg")
        val a3_song1 = Song(1,"Post","Björk","It's Oh So Quiet",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/its-oh-so-quiet.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/post.jpeg")
        val a3_song2 = Song(2,"Post","Björk","Isobel",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/isobel.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/post.jpeg")
        val a3_song3 = Song(3,"Post","Björk","Possibly Maybe",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/possibly-maybe.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/post.jpeg")
        val a3_song4 = Song(4,"Post","Björk","I Miss You",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/i-miss-you.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/post.jpeg")

        val a4_song0 = Song(0,"Restless","Xzibit","Front 2 Back",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/front-2-back.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/damn.jpeg")
        val a4_song1 = Song(1,"Restless","Xzibit","X",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/x.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/damn.jpeg")
        val a4_song2 = Song(2,"Restless","Xzibit","D.N.A. (Drugs-N-Alkahol)",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/dna-drugs-n-alkahol.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/damn.jpeg")
        val a4_song3 = Song(3,"Restless","Xzibit","Don't Approach Me",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/dont-aproach-me.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/damn.jpeg")

        val a5_song0 = Song(0,"DAMN.","Kendrick Lamar","BLOOD.",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/blood.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/damn.jpeg")
        val a5_song1 = Song(1,"DAMN.","Kendrick Lamar","DNA.",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/dna.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/damn.jpeg")
        val a5_song2 = Song(2,"DAMN.","Kendrick Lamar","ELEMENT.",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/element.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/damn.jpeg")
        val a5_song3 = Song(3,"DAMN.","Kendrick Lamar","FEEL.",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/feel.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/damn.jpeg")
        val a5_song4 = Song(4,"DAMN.","Kendrick Lamar","HUMBLE.",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/humble.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/damn.jpeg")
        val a5_song5 = Song(5,"DAMN.","Kendrick Lamar","XXX.",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/xxx.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/damn.jpeg")
        val a5_song6 = Song(6,"DAMN.","Kendrick Lamar","GOD.",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/god.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/damn.jpeg")

        val a6_song0 = Song(0,"The Real Slim Shady LP","Eminem","My Name Is",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/my-name-is.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/sslp.jpeg")
        val a6_song1 = Song(1,"The Real Slim Shady LP","Eminem","Guilty Conscience",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/guilty-conscience.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/sslp.jpeg")
        val a6_song2 = Song(2,"The Real Slim Shady LP","Eminem","Brain Damage",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/brain-damage.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/sslp.jpeg")
        val a6_song3 = Song(3,"The Real Slim Shady LP","Eminem","If I Had",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/if-i-had.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/sslp.jpeg")
        val a6_song4 = Song(4,"The Real Slim Shady LP","Eminem","'97 Bonnie & Clyde",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/97-bonnie-clyde.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/sslp.jpeg")
        val a6_song5 = Song(5,"The Real Slim Shady LP","Eminem","Role Model",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/role-model.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/sslp.jpeg")
        val a6_song6 = Song(6,"The Real Slim Shady LP","Eminem","My Fault",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/my-fault.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/sslp.jpeg")
        val a6_song7 = Song(7,"The Real Slim Shady LP","Eminem","Cum On Everybody",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/cum-on-everybody.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/sslp.jpeg")
        val a6_song8 = Song(8,"The Real Slim Shady LP","Eminem","Rock Bottom",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/rock-bottom.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/sslp.jpeg")
        val a6_song9 = Song(9,"The Real Slim Shady LP","Eminem","Just Don't Give A Fuck",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/just-dont-give-a-fuck.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/sslp.jpeg")
        val a6_song10 = Song(10,"The Real Slim Shady LP","Eminem","As The World Turns",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/as-the-world-turns.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/sslp.jpeg")
        val a6_song11 = Song(11,"The Real Slim Shady LP","Eminem","I'm Shady",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/im-shady.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/sslp.jpeg")
        val a6_song12 = Song(12,"The Real Slim Shady LP","Eminem","Bad Meets Evil",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/bad-meets-evil-feat-royce-59.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/sslp.jpeg")
        val a6_song13 = Song(13,"The Real Slim Shady LP","Eminem","Still Don't Give A Fuck",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/still-dont-give-a-fuck.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/sslp.jpeg")
        val a6_song14 = Song(14,"The Real Slim Shady LP","Eminem","Hazardous Youth",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/hazardous-youth.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/sslp.jpeg")

        val a7_song0 = Song(0,"Marshall Mathers LP 2","Eminem","Bad Guy",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/bad-guy.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/mmlp2.jpeg")
        val a7_song1 = Song(1,"Marshall Mathers LP 2","Eminem","Rhyme Or Reason",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/rhyme-or-reason.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/mmlp2.jpeg")
        val a7_song2 = Song(2,"Marshall Mathers LP 2","Eminem","Survival",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/survival.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/mmlp2.jpeg")
        val a7_song3 = Song(3,"Marshall Mathers LP 2","Eminem","Berzerk",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/berzerk.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/mmlp2.jpeg")
        val a7_song4 = Song(4,"Marshall Mathers LP 2","Eminem","Rap God",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/rap-god.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/mmlp2.jpeg")
        val a7_song5 = Song(5,"Marshall Mathers LP 2","Eminem","Brainless",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/brainless.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/mmlp2.jpeg")
        val a7_song6 = Song(6,"Marshall Mathers LP 2","Eminem","Headlights",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/headlights.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/mmlp2.jpeg")
        val a7_song7 = Song(7,"Marshall Mathers LP 2","Eminem","So Far.",
            "https://github.com/utkuoruc/spotify_repo/raw/master/music/so-far.mp3",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/mmlp2.jpeg")



        val album0 = Album("Lullabies To Paralyze","Queens Of The Stone Age",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/lullabies-to-paralyze.jpg",
            arrayListOf(song0,song1,song2,song3,song4,song5,song6,song7,song8,song9))
        val album1 = Album("Songs For The Deaf","Queens of the Stone Age",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/songs-for-the-deaf.jpeg",
            arrayListOf(sftd_0,sftd_1,sftd_2,sftd_3,sftd_4))
        val album2 = Album("Opp Pack Smoker","",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/opp-pack-smoker-5.jpeg",
            arrayListOf(song_0,song_1,song_2,song_3,song_4,song_5,song_6,song_7))
        val album3 = Album("Toxicity","System Of A Down",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/toxicity.jpeg",
            arrayListOf(toxicity_0,toxicity_1,toxicity_2,toxicity_3,toxicity_4,toxicity_5,toxicity_6,toxicity_7))
        val album4 = Album("Box Chevy","",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/box-chevy-playlist-cover.png",
            arrayListOf(box_0,box_1,box_2,box_3))
        val album5 = Album("Dressed Up As Life","Sick Puppies",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/dressed-up-as-life.jpg",
            arrayListOf(a0_song0,a0_song1,a0_song2,a0_song3,a0_song4))
        val album6 = Album("Vol.3: The Subliminal Verses","Slipknot",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/vol-3-the-subliminal-verses.jpeg",
            arrayListOf(a1_song0,a1_song1,a1_song2,a1_song3,a1_song4,a1_song5,a1_song6,a1_song7,a1_song8))
        val album7 = Album("Rated R","Queens of the Stone Age",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/rated-r.jpeg",
            arrayListOf(a2_song0,a2_song1,a2_song2,a2_song3,a2_song4,a2_song5,a2_song6))
        val album8 = Album("Post","Björk",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/post.jpeg",
            arrayListOf(a3_song0,a3_song1,a3_song2,a3_song3,a3_song4))
        val album9 = Album("Restless","Xzibit",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/restless.jpeg",
            arrayListOf(a4_song0,a4_song1,a4_song2,a4_song3))
        val album10 = Album("The Real Slim Shady LP","Eminem",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/sslp.jpeg",
            arrayListOf(a6_song0,a6_song1,a6_song2,a6_song3,a6_song4,a6_song5,a6_song6,a6_song7,a6_song8,a6_song9,a6_song10,a6_song11,a6_song12,a6_song13,a6_song14))
        val album11 = Album("Marshall Mathers LP 2","Eminem",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/mmlp2.jpeg",
            arrayListOf(a7_song0,a7_song1,a7_song2,a7_song3,a7_song4,a7_song5,a7_song6,a7_song7))
        val album12 = Album("DAMN.","Kendrick Lamar",
            "https://github.com/utkuoruc/spotify_repo/raw/master/cover/damn.jpeg",
            arrayListOf(a5_song0,a5_song1,a5_song2,a5_song3,a5_song4,a5_song5,a5_song6))
    }
}