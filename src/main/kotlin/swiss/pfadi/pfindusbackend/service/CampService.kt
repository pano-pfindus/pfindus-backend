package swiss.pfadi.pfindusbackend.service

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import swiss.pfadi.pfindusbackend.error.RequestException
import swiss.pfadi.pfindusbackend.model.Camp
import swiss.pfadi.pfindusbackend.presistance.CampRepository

@Service
class CampService(val campRepository: CampRepository) {

    fun getAllCamps(): List<Camp> {
        return campRepository.findAll().toList();
    }

    fun getCamp(id: Long): Camp {
        val campOptional = campRepository.findById(id);
        if (campOptional.isEmpty) throw RequestException("No camp with this id", HttpStatus.NOT_FOUND);
        return campOptional.get();
    }

    fun save(camp: Camp): Camp {
        camp.id = null;
        return forceSave(camp);
    }

    private fun forceSave(camp: Camp): Camp {
        if (camp.maxLeadersInCamp < camp.maxLeadersInGroup) {
            throw RequestException(
                "maximumLeadersInCamp must not be lower than maximumLeadersGroup",
                HttpStatus.BAD_REQUEST
            )
        }
        if (camp.maxParticipantsInCamp < camp.maxParticipantsInGroup) {
            throw RequestException(
                "maximumParticipantsInCamp must not be lower than maximumParticipantsInGroup",
                HttpStatus.BAD_REQUEST
            )
        }
        camp.contactEmail = camp.contactEmail?.replace("@", "(ät)") ?: null
        return campRepository.save(camp);
    }

    fun delete(id: Long) {
        val camp = getCamp(id);
        //todo before prod authorization
        campRepository.delete(camp)
    }

    fun update(id: Long, actualizedCamp: Camp): Camp {
        getCamp(id);
        //todo before prod authorization
        actualizedCamp.id = id;
        return forceSave(actualizedCamp);
    }

}
