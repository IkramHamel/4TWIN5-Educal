const Club = require("../models/club");

exports.getAllClubs = async (req, res) => {
  try {
    const { name } = req.query;
    let query = {};

    if (name) {
      // Case-insensitive search by name
      query = { nom: { $regex: new RegExp(name, "i") } };
    }

    const clubs = await Club.find(query);
    res.json(clubs);
  } catch (error) {
    res.status(500).json({ error: "Internal Server Error" });
  }
};

exports.createClub = async (req, res) => {
  try {
    const club = new Club(req.body);
    await club.save();
    res.status(201).json(club);
  } catch (error) {
    res.status(500).json({ error: "Internal Server Error" });
  }
};

exports.getClubById = async (req, res) => {
  try {
    const club = await Club.findById(req.params.id);
    if (!club) {
      return res.status(404).json({ error: "Club not found" });
    }
    res.json(club);
  } catch (error) {
    res.status(500).json({ error: "Internal Server Error" });
  }
};

exports.updateClub = async (req, res) => {
  try {
    const club = await Club.findByIdAndUpdate(req.params.id, req.body, {
      new: true,
    });
    if (!club) {
      return res.status(404).json({ error: "Club not found" });
    }
    res.json(club);
  } catch (error) {
    res.status(500).json({ error: "Internal Server Error" });
  }
};

exports.deleteClub = async (req, res) => {
  try {
    const club = await Club.findByIdAndDelete(req.params.id);
    if (!club) {
      return res.status(404).json({ error: "Club not found" });
    }
    res.json(club);
  } catch (error) {
    res.status(500).json({ error: "Internal Server Error" });
  }
};
