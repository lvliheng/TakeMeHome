/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.model

import androidx.compose.runtime.Immutable

@Immutable
data class Puppy(
    val age: String,
    val breed: String,
    val description: String,
    val gender: String,
    val name: String,
    val weight: String
)

object PuppiesRepo {
    fun getPuppies() = puppies
}

val puppies = listOf(
    Puppy(
        name = "Max",
        breed = "Dachshund",
        gender = "0",
        age = "1",
        weight = "1.1",
        description = "The dachshund, also known as the wiener dog, badger dog, or sausage dog, is a short-legged, long-bodied, hound-type dog breed. They may be smooth, wire, or long-haired.\\n\\nThe standard sized dachshund was developed to scent, chase, and flush out badgers and other burrow-dwelling animals, while the miniature dachshund was bred to hunt small animals such as rabbits and mice. In the Western United States, they have also been used to track wounded deer and hunt prairie dogs.\\n\\nDachshunds also participate in conformation shows, field trials and many other events organized through pure-bred dog organizations such as the American Kennel Club (AKC). According to the AKC, the dachshund is ranked 12th in popularity among dog breeds in the United States in 2018."
    ),
    Puppy(
        name = "Charlie",
        breed = "Chihuahua",
        gender = "1",
        age = "2",
        weight = "2.2",
        description = "The El Paso Chihuahuas are a Minor League Baseball team of the Triple-A West and the Triple-A affiliate of the San Diego Padres. They are located in El Paso, Texas, and play their home games at Southwest University Park, which opened in 2014. The Chihuahuas moved to El Paso from Tucson, Arizona, where they were known as the Tucson Padres. They played in the Pacific Coast League (PCL) until the 2021 restructuring of the minor leagues when they shifted to the Triple-A West. The Chihuahuas won the PCL championship in 2016."
    ),
    Puppy(
        name = "Cooper",
        breed = "Pug",
        gender = "0",
        age = "3",
        weight = "3.3",
        description = "The pug is a breed of dog with physically distinctive features of a wrinkly, short-muzzled face, and curled tail. The breed has a fine, glossy coat that comes in a variety of colours, most often light brown (fawn) or black, and a compact, square body with well-developed muscles.\n\nPugs were brought from China to Europe in the sixteenth century and were popularized in Western Europe by the House of Orange of the Netherlands, and the House of Stuart. In the United Kingdom, in the nineteenth century, Queen Victoria developed a passion for pugs which she passed on to other members of the Royal family.\n\nPugs are known for being sociable and gentle companion dogs. The American Kennel Club describes the breed's personality as \"even-tempered and charming\". Pugs remain popular into the twenty-first century, with some famous celebrity owners. A pug was judged Best in Show at the World Dog Show in 2004."
    ),
    Puppy(
        name = "Buddy",
        breed = "Pug",
        gender = "0",
        age = "4",
        weight = "4.1",
        description = "The pug is a breed of dog with physically distinctive features of a wrinkly, short-muzzled face, and curled tail. The breed has a fine, glossy coat that comes in a variety of colours, most often light brown (fawn) or black, and a compact, square body with well-developed muscles.\n\nPugs were brought from China to Europe in the sixteenth century and were popularized in Western Europe by the House of Orange of the Netherlands, and the House of Stuart. In the United Kingdom, in the nineteenth century, Queen Victoria developed a passion for pugs which she passed on to other members of the Royal family.\n\nPugs are known for being sociable and gentle companion dogs. The American Kennel Club describes the breed's personality as \"even-tempered and charming\". Pugs remain popular into the twenty-first century, with some famous celebrity owners. A pug was judged Best in Show at the World Dog Show in 2004."
    ),
    Puppy(
        name = "Jack",
        breed = "Pug",
        gender = "1",
        age = "5",
        weight = "5.2",
        description = "The pug is a breed of dog with physically distinctive features of a wrinkly, short-muzzled face, and curled tail. The breed has a fine, glossy coat that comes in a variety of colours, most often light brown (fawn) or black, and a compact, square body with well-developed muscles.\n\nPugs were brought from China to Europe in the sixteenth century and were popularized in Western Europe by the House of Orange of the Netherlands, and the House of Stuart. In the United Kingdom, in the nineteenth century, Queen Victoria developed a passion for pugs which she passed on to other members of the Royal family.\n\nPugs are known for being sociable and gentle companion dogs. The American Kennel Club describes the breed's personality as \"even-tempered and charming\". Pugs remain popular into the twenty-first century, with some famous celebrity owners. A pug was judged Best in Show at the World Dog Show in 2004."
    )
//    ,
//    Puppy(
//        name = "Rocky",
//        breed = "Pug",
//        gender = "0",
//        age = "6",
//        weight = "6.3",
//        description = "The pug is a breed of dog with physically distinctive features of a wrinkly, short-muzzled face, and curled tail. The breed has a fine, glossy coat that comes in a variety of colours, most often light brown (fawn) or black, and a compact, square body with well-developed muscles.\n\nPugs were brought from China to Europe in the sixteenth century and were popularized in Western Europe by the House of Orange of the Netherlands, and the House of Stuart. In the United Kingdom, in the nineteenth century, Queen Victoria developed a passion for pugs which she passed on to other members of the Royal family.\n\nPugs are known for being sociable and gentle companion dogs. The American Kennel Club describes the breed's personality as \"even-tempered and charming\". Pugs remain popular into the twenty-first century, with some famous celebrity owners. A pug was judged Best in Show at the World Dog Show in 2004."
//    )
//    ,
//    Puppy(
//        name = "Puppy7",
//        breed = "Pug",
//        gender = "1",
//        age = "7",
//        weight = "7.1",
//        description = "The pug is a breed of dog with physically distinctive features of a wrinkly, short-muzzled face, and curled tail. The breed has a fine, glossy coat that comes in a variety of colours, most often light brown (fawn) or black, and a compact, square body with well-developed muscles.\n\nPugs were brought from China to Europe in the sixteenth century and were popularized in Western Europe by the House of Orange of the Netherlands, and the House of Stuart. In the United Kingdom, in the nineteenth century, Queen Victoria developed a passion for pugs which she passed on to other members of the Royal family.\n\nPugs are known for being sociable and gentle companion dogs. The American Kennel Club describes the breed's personality as \"even-tempered and charming\". Pugs remain popular into the twenty-first century, with some famous celebrity owners. A pug was judged Best in Show at the World Dog Show in 2004."
//    )
//    ,
//    Puppy(
//        name = "Puppy8",
//        breed = "Pug",
//        gender = "0",
//        age = "8",
//        weight = "7.2",
//        description = "The pug is a breed of dog with physically distinctive features of a wrinkly, short-muzzled face, and curled tail. The breed has a fine, glossy coat that comes in a variety of colours, most often light brown (fawn) or black, and a compact, square body with well-developed muscles.\n\nPugs were brought from China to Europe in the sixteenth century and were popularized in Western Europe by the House of Orange of the Netherlands, and the House of Stuart. In the United Kingdom, in the nineteenth century, Queen Victoria developed a passion for pugs which she passed on to other members of the Royal family.\n\nPugs are known for being sociable and gentle companion dogs. The American Kennel Club describes the breed's personality as \"even-tempered and charming\". Pugs remain popular into the twenty-first century, with some famous celebrity owners. A pug was judged Best in Show at the World Dog Show in 2004."
//    )
)
