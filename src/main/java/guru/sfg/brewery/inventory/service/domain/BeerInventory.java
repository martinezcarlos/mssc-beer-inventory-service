/*
 *  Copyright 2019 the original author or authors.
 *
 * This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package guru.sfg.brewery.inventory.service.domain;

import java.sql.Timestamp;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

/** Created by jt on 2019-01-26. */
@Getter
@Setter
@NoArgsConstructor
@Entity
public class BeerInventory extends BaseEntity {

  @Type(type = "org.hibernate.type.UUIDCharType")
  @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
  private UUID beerId;

  private String upc;
  private Integer quantityOnHand = 0;

  @Builder
  public BeerInventory(
      final UUID id,
      final Long version,
      final Timestamp createdDate,
      final Timestamp lastModifiedDate,
      final UUID beerId,
      final String upc,
      final Integer quantityOnHand) {
    super(id, version, createdDate, lastModifiedDate);
    this.beerId = beerId;
    this.upc = upc;
    this.quantityOnHand = quantityOnHand;
  }
}
