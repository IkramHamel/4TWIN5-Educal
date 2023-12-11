const mongoose = require("mongoose");

const clubSchema = new mongoose.Schema({
  nom: String,
  description: String,
  image: String,
});

const Club = mongoose.model("Club", clubSchema);

module.exports = Club;
