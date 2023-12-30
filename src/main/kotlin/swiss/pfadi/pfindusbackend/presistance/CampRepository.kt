package swiss.pfadi.pfindusbackend.presistance

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import swiss.pfadi.pfindusbackend.model.Camp

@Repository
interface CampRepository : CrudRepository<Camp, Long> {
}
