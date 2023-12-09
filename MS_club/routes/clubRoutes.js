const express = require("express");
const router = express.Router();
const clubController = require("../controllers/clubController");

router.get("/", clubController.getAllClubs);
router.post("/", clubController.createClub);
router.get("/:id", clubController.getClubById);
router.put("/:id", clubController.updateClub);
router.delete("/:id", clubController.deleteClub);

module.exports = router;
