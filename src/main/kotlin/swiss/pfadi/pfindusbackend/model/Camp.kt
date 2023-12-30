package swiss.pfadi.pfindusbackend.model

import jakarta.persistence.*
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.PositiveOrZero
import java.util.*

@Table
@Entity
data class Camp(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long?,

    @field:NotBlank
    val groupName: String,

    @field:NotBlank
    val groupPlace: String,

    @field:NotBlank
    val groupCanton: Canton,

    val groupLevel: List<Level>,

    val earliestPossibleDate: Date,

    val lastPossibleDate: Date,

    @field:PositiveOrZero
    val durationInDays: Int,

    @field:NotBlank
    val campType: CampType,

    @field:PositiveOrZero
    val minParticipantsInGroup: Int,

    @field:PositiveOrZero
    val maxParticipantsInGroup: Int,

    @field:PositiveOrZero
    val maxParticipantsInCamp: Int,

    @field:PositiveOrZero
    val minLeadersInGroup: Int,

    @field:PositiveOrZero
    val maxLeadersInGroup: Int,

    @field:PositiveOrZero
    val maxLeadersInCamp: Int,

    val aufbauExisting: Boolean,

    @field:PositiveOrZero
    val leaderBasisKids: Int,

    @field:PositiveOrZero
    val leaderBasisTeens: Int,

    val additionalQualifications: String,

    @field:NotBlank
    val organised: List<OrganisableItem>,

    @field:NotBlank
    @field:Email
    var contactEmail: String?,

    val additionalInfo: String
)
